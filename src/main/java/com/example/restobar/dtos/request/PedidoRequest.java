package com.example.restobar.dtos.request;

import lombok.Data;
import java.util.List;
@Data
public class PedidoRequest {

    private MesaRequest mesa;
    private List<ItemRequest> items;

}
