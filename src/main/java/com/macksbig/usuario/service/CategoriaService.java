package com.macksbig.usuario.service;

import com.macksbig.usuario.entity.Categoria;
import com.macksbig.usuario.repository.CategoriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    
    @Autowired
    public CategoriaRepository categoriaRepository;
    
    public void guardarCategoria(Categoria categoria){
       categoriaRepository.save(categoria);
    }
    public List<Categoria> getCategorias() {
        return categoriaRepository.findAll();
    }
    public Categoria getByName(String name){
        return categoriaRepository.getByName(name);
    }
    public void deleteById(Long id){
        categoriaRepository.deleteById(id);
    }
}
