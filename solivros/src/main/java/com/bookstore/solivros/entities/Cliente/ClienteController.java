package com.bookstore.solivros.entities.Cliente;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import lombok.AllArgsConstructor;

@RequestMapping("/cliente")
@AllArgsConstructor
@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long id){
        return clienteRepository.findById(id)
            .map(cliente -> ResponseEntity.ok(cliente))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar(@Valid @RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @PutMapping
    public ResponseEntity<Cliente>  editar(@Valid @PathVariable Long id, @RequestBody Cliente cliente){
        if(clienteRepository.existsById(id)){
            cliente.setId(id);
            cliente = clienteRepository.save(cliente);

            return ResponseEntity.ok(cliente);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping 
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        if(clienteRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }

        clienteRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
