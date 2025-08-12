package com.curso.cursado2.config;

import com.curso.cursado2.servicio.UsuarioServicio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InicializacionDatos {
    @Bean
    public CommandLineRunner initUsuarios(UsuarioServicio usuarioServicio) {
        return args -> {
            usuarioServicio.crearUsuario("admin", "admin123", "ADMIN");
            usuarioServicio.crearUsuario("user", "user123", "USER");
        };
    }
}
