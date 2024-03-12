/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.macksbig.usuario.controller;

import com.macksbig.usuario.entity.Categoria;
import com.macksbig.usuario.service.CategoriaService;
import com.macksbig.usuario.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping("/")
    public ResponseEntity<List<Categoria>> getCategorias(){
        List<Categoria> listC = categoriaService.getCategorias();
        return ResponseEntity.status(HttpStatus.OK).body(listC);
    }
    @PostMapping("/")
    public ResponseEntity<Boolean> savesUser(@RequestBody Categoria categoria){
          categoriaService.guardarCategoria(categoria);
       return ResponseEntity.status(HttpStatus.OK).body(Boolean.TRUE);
    }
      @GetMapping("/user/{name}")
    public ResponseEntity<Categoria> getUsuarioByName(@PathVariable String name){
       Categoria user =  categoriaService.getByName(name);
       return ResponseEntity.status(HttpStatus.OK).body(user);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id){
        categoriaService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(Boolean.TRUE);
    }
}
