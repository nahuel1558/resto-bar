package com.example.restobar.controllers;

import com.example.restobar.dtos.request.ItemRequest;
import com.example.restobar.dtos.request.MesaRequest;
import com.example.restobar.dtos.request.PedidoRequest;
import com.example.restobar.dtos.response.ItemResponse;
import com.example.restobar.dtos.response.PedidoResponse;
import com.example.restobar.models.Item;
import com.example.restobar.models.Mesa;
import com.example.restobar.models.Pedido;
import com.example.restobar.services.ItemServiceImpl;
import com.example.restobar.services.MesaServiceImpl;
import com.example.restobar.services.PedidoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@Controller
@RequestMapping(path = "/pedidos")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoServiceImpl> {
    private PedidoServiceImpl pedidoService;
   /* private MesaServiceImpl mesaService;
    private ItemServiceImpl itemService;

    @Autowired
    public PedidoController(PedidoServiceImpl servicio, MesaServiceImpl mesaService, ItemServiceImpl itemService) {
        this.mesaService = mesaService;
        this.pedidoService = servicio;
        this.itemService = itemService;
    }
*/

    @PostMapping("/crearPedido")
    public ResponseEntity<?> crearPedidoConItem(@RequestBody PedidoRequest pedidoRequest) {
        try {

            return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.crearPedidoConItem());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear el pedido");
        }
    }
}
