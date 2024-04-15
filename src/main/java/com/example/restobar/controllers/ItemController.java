package com.example.restobar.controllers;

import com.example.restobar.dtos.request.ItemRequest;
import com.example.restobar.dtos.response.ItemResponse;
import com.example.restobar.models.Item;
import com.example.restobar.services.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@Controller
@RequestMapping(path = "/items")
public class ItemController extends BaseControllerImpl<Item, ItemServiceImpl>{
/*
    @Autowired
    public ItemController(ItemServiceImpl servicio) {
        super(servicio);
    }

    @PostMapping("/crearItem")
    public ItemResponse crearItem(@RequestBody ItemRequest itemRequest) throws Exception {
        // Crear el item utilizando el servicio y el objeto ItemRequest
        Item item = new Item();
        // Configurar los campos del item según el request
        item = servicio.save(item);

        // Aquí puedes retornar una respuesta con la información del item creado
        return new ItemResponse(item.getId(), item.getProducto(), item.getCantidad(), item.getPrecioTotal());
    }*/
}
