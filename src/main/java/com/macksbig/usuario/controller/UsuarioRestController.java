package com.macksbig.usuario.controller;

import com.macksbig.usuario.entity.Usuario;
import com.macksbig.usuario.service.UsuarioService;
import com.macksbig.usuario.util.JWTUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioRestController {
    
    @Autowired
    private UsuarioService  usuarioService;
    
    @Autowired
    private JWTUtil jwtUtil;
    
    @GetMapping("/")
    public ResponseEntity<List<Usuario>> getUsuarios(@RequestHeader(value="Authorization") String token){
        
       String usuarioId = jwtUtil.getKey(token);
       Usuario user = usuarioService.getById(Long.valueOf(usuarioId));
       
      
       if (user == null){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
       
       if(user.getRol().equals("USER")){
       return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
       } else if(user.getRol().equals("ADMIN")){
           List<Usuario> users =  usuarioService.getUsers();
           return ResponseEntity.status(HttpStatus.OK).body(users);
       }
       else{ 
       return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
       }
       
    }
    
    @PostMapping("/")
    public ResponseEntity<Boolean> savesUser(@RequestBody Usuario user){
          usuarioService.saveUser(user);
       return ResponseEntity.status(HttpStatus.OK).body(Boolean.TRUE);
    }
    
    @GetMapping("/user/{name}")
    public ResponseEntity<Usuario> getUsuarioByName(@PathVariable String name){
       Usuario user =  usuarioService.getUserByName(name);
       return ResponseEntity.status(HttpStatus.OK).body(user);
    }
    
    @DeleteMapping("/delete/{name}")
    public ResponseEntity<Boolean> deleteUserByName(@PathVariable String name){
        usuarioService.deleteByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(Boolean.TRUE);
    }
    
}
