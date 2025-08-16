package com.curso.cursado2.servicio;

import com.curso.cursado2.excepciones.EmailDuplicadoException;
import com.curso.cursado2.repositorio.ClienteRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.curso.cursado2.modelo.Cliente;

import java.util.List;

@Service
public class ClienteServicio {
    private final ClienteRepositorio clienteRepositorio;

    @Autowired
    public ClienteServicio(ClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    @Transactional
    public Cliente guardarCliente(Cliente cliente) {
        if(cliente.getEmail() == null || cliente.getEmail().isBlank()) {
            throw new IllegalArgumentException("El email no puede estar vacío");
        }
        if(clienteRepositorio.existsByEmail(cliente.getEmail())) {
            throw new EmailDuplicadoException("Ya existe un cliente con ese email");
        }
        return clienteRepositorio.save(cliente);
    }
    public List<Cliente> listarClientes() {
        return clienteRepositorio.findAll();
    }
}
