package com.example.restobar.dtos;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemResponse {
    private Long id;
    private ProductoResponse producto;
    private Integer cantidad;
    private Float precioTotal;

}
