package com.bookstore.solivros.entities.Cliente;

import org.springframework.stereotype.Service;

@Service
 class ClienteServiceImpl implements ClienteService{
    
    ClienteRepository clienteRepository;

    @Override
    public String salvar(Cliente cliente){
        clienteRepository.save(cliente);
        return "Cliente salvo perfeitamente";

    }
}
