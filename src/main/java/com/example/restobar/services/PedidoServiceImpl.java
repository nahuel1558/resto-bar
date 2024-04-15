package com.example.restobar.services;

import com.example.restobar.models.Item;
import com.example.restobar.models.Mesa;
import com.example.restobar.models.Pedido;
import com.example.restobar.repositories.BaseRepository;
import com.example.restobar.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class PedidoServiceImpl extends BaseServiceImple<Pedido, Long> implements PedidoService{


    private PedidoRepository pedidoRepository;
    private ItemService itemService;
    private MesaService mesaService;
    @Autowired
    public PedidoServiceImpl(PedidoRepository pedidoRepository, ItemService itemService, MesaService mesaService) {
        super(pedidoRepository);
        this.pedidoRepository = pedidoRepository;
        this.itemService = itemService;
        this.mesaService = mesaService;
    }

    @Override
    @Transactional
    public Pedido crearPedidoConItem(Pedido pedido, Long idProducto, Float cantidad, Long mesaId) throws Exception {
        try {
            // Crear el item con el producto
            Item item = itemService.crearItemConProducto(idProducto, cantidad);
            // Agregar el item al pedido
            pedido.getItems().add(item);
            // Calcular el precio total del pedido sumando los precios totales de los items
            Float precioTotalPedido = pedido.getItems().stream()
                    .map(Item::getPrecioTotal)
                    .reduce(0f, Float::sum);
            pedido.setPrecioTotal(precioTotalPedido);
            // Establecer la fecha actual si no se proporciona
            if (pedido.getFecha() == null) {
                pedido.setFecha(LocalDate.now());
            }
            // Guardar el pedido en la base de datos
            Mesa mesa = mesaService.findById(mesaId);
            pedido.setMesa(mesa);
            return pedidoRepository.save(pedido);
        } catch (Exception e) {
            throw new Exception("Error al crear el pedido con el item: " + e.getMessage());
        }
    }
    public PedidoServiceImpl(BaseRepository<Pedido, Long> baseRepository){super(baseRepository);}
}
