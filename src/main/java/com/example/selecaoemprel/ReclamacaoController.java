package com.example.selecaoemprel;

import java.util.Optional;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReclamacaoController {

    @Autowired
    private ReclamcacaoRepository reclamacaoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
   
    @Transactional
    @PostMapping("/registrar")
    public ResponseEntity<String> registro(@RequestBody @Validated ReclamacaoDto reclamacaoDto){
                Optional<ReclamacaoModel> recOptional = reclamacaoRepository.findByReclam(ReclamacaoDto.getReclam());
        if (recOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dados inválidos");
        }
       
        Optional<ClienteModel> clienteOptional = clienteRepository.findById(reclamacaoDto.getId());
        if (clienteOptional.isEmpty()) {
            ClienteModel cliente = new ClienteModel(reclamacaoDto.getCpf());
            clienteRepository.save(cliente);
        }
        ClienteModel cliente = clienteRepository.findByCpf(reclamacaoDto.getCpf()).get();
        ReclamacaoModel reclamacaoModel = new ReclamacaoModel();
        BeanUtils.copyProperties(reclamacaoDto, reclamacaoModel);
        reclamacaoModel.setCliente(cliente);
        Random random = new Random();
        reclamacaoModel.setProtocolo(Integer.toString(random.nextInt()).substring(3));
        reclamacaoRepository.save(reclamacaoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body("Protocolo: " + reclamacaoModel.getProtocolo());
    }

    @Transactional
    @DeleteMapping("/remover/{protocolo}")
    public ResponseEntity<String> deletePost(@PathVariable String protocolo ) {
        Optional<ReclamacaoModel> reclamacaoOptional = reclamacaoRepository.findByProtocolo(protocolo);
        if (reclamacaoOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Protocolo inválido");
        }
        reclamacaoRepository.delete(reclamacaoOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Reclamacao removida com sucesso");

    }
}
