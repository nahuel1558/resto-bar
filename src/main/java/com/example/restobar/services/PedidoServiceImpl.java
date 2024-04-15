package com.example.restobar.services;

import com.example.restobar.models.Pedido;
import com.example.restobar.repositories.BaseRepository;
import com.example.restobar.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl extends BaseServiceImple<Pedido, Long> implements PedidoService{

    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoServiceImpl(BaseRepository<Pedido, Long> baseRepository){super(baseRepository);}
}
