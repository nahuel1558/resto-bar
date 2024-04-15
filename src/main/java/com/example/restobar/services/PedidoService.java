package com.example.restobar.services;

import com.example.restobar.models.Pedido;
import org.springframework.stereotype.Service;

@Service
public interface PedidoService extends BaseService<Pedido, Long> {
    Pedido crearPedidoConItem(Pedido pedido, Long idProducto, Float cantidad,Long mesaId) throws Exception;

}
