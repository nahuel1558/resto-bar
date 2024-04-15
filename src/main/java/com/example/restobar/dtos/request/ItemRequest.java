package com.example.restobar.dtos.request;

import com.example.restobar.dtos.response.ProductoResponse;
import lombok.Data;

@Data
public class ItemRequest {

    private ProductoRequest producto;
    private Float cantidad;

}
