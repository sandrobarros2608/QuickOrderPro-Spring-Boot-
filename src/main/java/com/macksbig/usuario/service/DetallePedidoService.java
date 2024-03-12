/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.macksbig.usuario.service;

import com.macksbig.usuario.entity.DetallePedido;
import com.macksbig.usuario.entity.Pedido;
import com.macksbig.usuario.entity.Producto;
import com.macksbig.usuario.repository.DetallePedidoRepository;
import com.macksbig.usuario.repository.PedidoRepository;
import com.macksbig.usuario.repository.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author edgar
 */
@Service
public class DetallePedidoService {
    @Autowired
    private DetallePedidoRepository detallePedidoRepository;
    
    @Autowired
    private PedidoRepository pedidoRepository;
    
    @Autowired
    private ProductoRepository productoRepository;
    

    public void guardarDetallePedido(DetallePedido detallePedido) {
        
        Pedido p = pedidoRepository.getById(detallePedido.getPedido().getId());
        Producto pr = productoRepository.getById(detallePedido.getProducto().getId());
        p.setTotal((pr.getPrecio()* detallePedido.getCantidadDeseada()) + p.getTotal());
        
        detallePedidoRepository.save(detallePedido);
        
    }

    public List<DetallePedido> traerTodos() {
        return detallePedidoRepository.findAll();
    }

    public void eliminarDetallePedidoId(Long id) {
        
        DetallePedido dp = detallePedidoRepository.getById(id);
        Producto pr = dp.getProducto();
        Pedido p = pedidoRepository.getById(dp.getPedido().getId());
        p.setTotal(p.getTotal() - (pr.getPrecio() * dp.getCantidadDeseada()));
        
        detallePedidoRepository.deleteById(id);
    }
}
