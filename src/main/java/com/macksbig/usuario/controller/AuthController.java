/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.macksbig.usuario.controller;

import com.macksbig.usuario.entity.Usuario;
import com.macksbig.usuario.repository.UsuarioRepository;
import com.macksbig.usuario.util.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author edgar
 */
@RestController
public class AuthController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private JWTUtil jwtUtil;
    
    @PostMapping("/api/login")
    public String login(@RequestBody Usuario usuario){
        String correo = usuario.getCorreo();
        String contraseña= usuario.getContraseña();
        
        
        Usuario usuarioLoggeado = usuarioRepository.verificarCredenciales(correo);
        if (usuarioLoggeado == null){
            return null;
        }
        
        
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        Boolean contraseñaEsIgual = argon2.verify(usuarioLoggeado.getContraseña(), contraseña);
        
        if (contraseñaEsIgual) {
            return jwtUtil.create(String.valueOf(usuarioLoggeado.getId()), usuarioLoggeado.getCorreo());
        }
        return null;
        
    }
}
