/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.macksbig.usuario.repository;

import com.macksbig.usuario.entity.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author edgar
 */
@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long> {
}

