/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.macksbig.usuario.controller;



import com.macksbig.usuario.entity.Pedido;
import com.macksbig.usuario.service.PedidoService;
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
@RequestMapping("/pedido")
public class PedidoController {
    
    @Autowired
    private PedidoService pedidoService;
    
    @GetMapping("/")
    public ResponseEntity<List<Pedido>> getPedidos(){
        List<Pedido> listPe = pedidoService.getPedidos();
        return ResponseEntity.status(HttpStatus.OK).body(listPe);
    }
    @PostMapping("/")
    public ResponseEntity<Boolean> savesPedido(@RequestBody Pedido pedido){
          pedidoService.guardarPedido(pedido);
       return ResponseEntity.status(HttpStatus.OK).body(Boolean.TRUE);
    }
      @GetMapping("/pedido/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable Long id){
       Pedido user =  pedidoService.getById(id);
       return ResponseEntity.status(HttpStatus.OK).body(user);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id){
        pedidoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(Boolean.TRUE);
    }
    
}
