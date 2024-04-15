package com.example.restobar.controllers;

import com.example.restobar.dtos.request.ItemRequest;
import com.example.restobar.dtos.request.PedidoRequest;
import com.example.restobar.dtos.response.ItemResponse;
import com.example.restobar.models.Item;
import com.example.restobar.models.Pedido;
import com.example.restobar.services.PedidoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@Controller
@RequestMapping(path = "/pedidos")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoServiceImpl>{
    /*private final ItemController itemController;

    @Autowired
    public PedidoController(PedidoServiceImpl servicio, ItemController itemController) {
        super(servicio);
        this.itemController = itemController;
    }

    @PostMapping("/crearPedido")
    public ResponseEntity<?> crearPedidoConItem(@RequestBody PedidoRequest pedidoRequest) {
        try {
            // Crear el pedido
            Pedido pedido = new Pedido();
            // Configurar otros campos del pedido según el request si es necesario
            pedido.setNombreMesa(pedidoRequest.getNombreMesa()); // Por ejemplo, si tienes un campo para el nombre de la mesa

            // Crear un ítem para el pedido
            Item item = new Item();
            // Configurar el ítem según el request
            // Por ejemplo, puedes establecer el producto y la cantidad del ítem
            item.setProducto(pedidoRequest.getProducto());
            item.setCantidad(pedidoRequest.getCantidad());

            // Agregar el ítem al pedido
            pedido.addItem(item);

            // Guardar el pedido
            pedido = servicio.save(pedido);

            return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear el pedido");
        }
    }*/
}
