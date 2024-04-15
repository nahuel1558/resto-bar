package com.example.restobar.dtos.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Data;

@Getter
@Builder
@Data
public class ProductoResponse {
    private String nombre;
    private String descripcion;
    private String costo;
    private String precio;
}
