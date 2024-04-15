package com.example.restobar.dtos.response;
import lombok.Builder;
import lombok.Getter;
import lombok.Data;

import java.util.List;

@Getter
@Builder
@Data
public class PedidoResponse {

    private MesaResponse mesa;
    private String fecha;
    private List<ItemResponse> items; // Suponiendo que un pedido puede tener varios ítems
    private Float precioTotal;

}
