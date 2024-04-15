package com.example.restobar.dtos.request;

import lombok.Data;

@Data
public class ProductoRequest {
    private String nombre;
    private String descripcion;
    private Float costo;
    private Float precio;
}
