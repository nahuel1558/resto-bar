package com.example.restobar.services;

import com.example.restobar.dtos.request.ItemRequest;
import com.example.restobar.models.Item;
import com.example.restobar.models.Mesa;
import com.example.restobar.models.Pedido;
import org.springframework.stereotype.Service;

@Service
public interface PedidoService extends BaseService<Pedido, Long> {
    Pedido crearPedidoConItem(Pedido pedido, Mesa mesa, Item items) throws Exception;

}
