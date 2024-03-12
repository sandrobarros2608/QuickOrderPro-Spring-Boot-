/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.macksbig.usuario.controller;

import com.macksbig.usuario.entity.DetallePedido;
import com.macksbig.usuario.service.DetallePedidoService;
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

/**
 *
 * @author edgar
 */
@RestController
@RequestMapping("/detallepedido")
public class DetallePedidoController {

    @Autowired
    private DetallePedidoService detallePedidoService;

    @PostMapping("/")
    public ResponseEntity<Boolean> guardarDetallePedido(@RequestBody DetallePedido detallePedido) {
        detallePedidoService.guardarDetallePedido(detallePedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(Boolean.TRUE);
    }

    @GetMapping("/")
    public ResponseEntity<List<DetallePedido>> traerTodos() {
        List<DetallePedido> detallePedidos = detallePedidoService.traerTodos();
        return ResponseEntity.status(HttpStatus.OK).body(detallePedidos);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Boolean> eliminarUnDetallePedido(@PathVariable Long id) {
        detallePedidoService.eliminarDetallePedidoId(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }  
}
