package com.example.restobar.dtos.request;

import lombok.Data;
import java.util.List;
@Data
public class PedidoRequest {

    private Long mesaId;
    private List<ItemRequest> items;

}
