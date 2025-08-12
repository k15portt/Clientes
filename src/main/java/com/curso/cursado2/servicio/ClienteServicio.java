package com.curso.cursado2.servicio;

import com.curso.cursado2.repositorio.ClienteRepositorio;
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

    public Cliente guardarCliente(Cliente cliente) {
        // Aquí se implementaría la lógica para guardar un cliente
        // Por ejemplo, clienteRepositorio.save(cliente);
        return clienteRepositorio.save(cliente);
    }
    public List<Cliente> listarClientes() {
        // Aquí se implementaría la lógica para listar los clientes
        // Por ejemplo, clienteRepositorio.findAll();
        return clienteRepositorio.findAll();
    }
}
