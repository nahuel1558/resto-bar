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

        Item item = new Item();

        item = servicio.save(item);


        return new ItemResponse(item.getId(), item.getProducto(), item.getCantidad(), item.getPrecioTotal());
    }*/
}
