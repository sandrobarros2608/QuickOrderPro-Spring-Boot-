package com.macksbig.usuario.service;


import com.macksbig.usuario.entity.DetallePedido;
import com.macksbig.usuario.entity.Pedido;
import com.macksbig.usuario.entity.Producto;
import com.macksbig.usuario.repository.DetallePedidoRepository;
import com.macksbig.usuario.repository.PedidoRepository;
import java.util.List;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    
    @Autowired
    public PedidoRepository pedidoRepo;
    
    
    
    
    public void guardarPedido(Pedido pedido){
       pedidoRepo.save(pedido);
    }
    public List<Pedido> getPedidos() {
        return pedidoRepo.findAll();
    }
    public Pedido getById(Long id){
        return pedidoRepo.getById(id);
    }
    public void deleteById(Long id){
        pedidoRepo.deleteById(id);
    }
}
