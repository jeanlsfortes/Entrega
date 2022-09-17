package com.solivros.solivros.entities.Cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;
    
    @GetMapping("/clientes")
    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }
}
