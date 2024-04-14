package com.example.restobar.dtos;

import lombok.Data;

@Data
public class ProductoRequest {
    private String nombre;
    private String descripcion;
    private String costo;
    private String precio;
}
