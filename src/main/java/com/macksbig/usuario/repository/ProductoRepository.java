package com.macksbig.usuario.repository;

import com.macksbig.usuario.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{
    
    @Query("SELECT p FROM Producto p WHERE p.nombre = :name")
    public Producto getByName(String name);
}
