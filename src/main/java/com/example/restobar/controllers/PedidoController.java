package com.example.restobar.controllers;

import com.example.restobar.models.Pedido;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@Controller
@RequestMapping(path = "/pedidos")
public class PedidoController extends BaseControllerImpl<Pedido, Long>{
}
