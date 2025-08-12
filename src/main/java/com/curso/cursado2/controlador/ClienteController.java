package com.curso.cursado2.controlador;

import com.curso.cursado2.modelo.Cliente;
import com.curso.cursado2.servicio.ClienteServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Clientes")
public class ClienteController {

    private final ClienteServicio clienteServicio;

    @Autowired
    public ClienteController(ClienteServicio clienteServicio) {
        this.clienteServicio = clienteServicio;
    }

    @GetMapping
    public List<Cliente> obtenerClientes() {
        return clienteServicio.listarClientes();
    }
    @PostMapping
    public ResponseEntity<?> crearCliente(@Valid @RequestBody Cliente cliente) {
        try{
            return ResponseEntity.ok(clienteServicio.guardarCliente(cliente));
        }catch(DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Error: El email ya está en uso.");
        }
    }
}