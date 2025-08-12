package com.curso.cursado2.controlador;

import com.curso.cursado2.modelo.Cliente;
import com.curso.cursado2.servicio.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClienteController {
    // Aquí se implementaría la lógica del controlador para manejar las solicitudes HTTP
    // Por ejemplo, métodos para crear, leer, actualizar y eliminar clientes
    // Se inyectaría el servicio ClienteServicio para interactuar con los datos de los clientes
    // @Autowired
    // private ClienteServicio clienteServicio;

    // Métodos de ejemplo:
    // @PostMapping("/clientes")
    // public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
    //     return ResponseEntity.ok(clienteServicio.guardarCliente(cliente));
    // }

    // @GetMapping("/clientes")
    // public List<Cliente> obtenerClientes() {
    //     return clienteServicio.listarClientes();

    @Autowired
    private ClienteServicio clienteServicio;

    @GetMapping("/clientes")
    public List<Cliente> obtenerClientes() {
        return clienteServicio.listarClientes();
    }
    @PostMapping("/clientes")
    public ResponseEntity<?> crearCliente(@RequestBody Cliente cliente) {
        try{
            return ResponseEntity.ok(clienteServicio.guardarCliente(cliente));
        }catch(DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Error: El email ya está en uso.");
        }
    }
}
