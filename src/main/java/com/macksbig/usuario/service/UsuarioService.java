
package com.macksbig.usuario.service;

import com.macksbig.usuario.entity.Usuario;
import com.macksbig.usuario.repository.UsuarioRepository;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    
    public void saveUser (Usuario usuario ){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1,1024,1,usuario.getContraseña());
        usuario.setContraseña(hash);
      usuarioRepository.save(usuario);
    }
    
    public List<Usuario> getUsers() {
        return usuarioRepository.findAll();
    }
    
    public void deleteByName(String name){
        if(usuarioRepository.getByName(name) != null){    
            Usuario u = usuarioRepository.getByName(name);
            usuarioRepository.deleteById(u.getId());
        }
    }
    
    public Usuario getUserByName(String name){
     return usuarioRepository.getByName(name);
    }
    
    public Usuario getById(Long id){
    Optional<Usuario> u = usuarioRepository.findById(id);
     if(u.isEmpty()){
     return null;
     } else {
     return u.get();
     }
     
    }
    
}
