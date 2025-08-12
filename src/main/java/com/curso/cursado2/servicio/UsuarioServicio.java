package com.curso.cursado2.servicio;

import com.curso.cursado2.modelo.Usuario;
import com.curso.cursado2.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void crearUsuario(String username, String password, String rol) {
        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setPassword(passwordEncoder.encode(password)); // Encripta la contraseña
        usuario.setRol(rol); // Por ejemplo: "ADMIN"
        usuarioRepositorio.save(usuario);
    }
}
