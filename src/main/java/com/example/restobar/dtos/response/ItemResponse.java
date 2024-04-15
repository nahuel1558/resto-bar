package com.example.restobar.dtos.response;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemResponse {
    private Long id;
    private ProductoResponse producto;
    private Float cantidad;
    private Float precioTotal;

}
