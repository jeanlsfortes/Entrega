package com.solivros.solivros.entities.Cliente;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    
    @GetMapping("/clientes")
    public String testando(){
        return "tudo mec manito";
    }
}
