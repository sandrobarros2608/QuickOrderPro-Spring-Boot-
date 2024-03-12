package com.macksbig.usuario.service;

import com.macksbig.usuario.entity.Producto;
import com.macksbig.usuario.repository.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    
    @Autowired
    public ProductoRepository productoRepository;
    
    public void guardarProducto(Producto producto){
       productoRepository.save(producto);
    }
    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }
    public Producto getByName(String name){
        return productoRepository.getByName(name);
    }
    public void deleteById(Long id){
        productoRepository.deleteById(id);
    }
}
