package com.curso.cursado2.repositorio;

import com.curso.cursado2.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente,Long> {
}
