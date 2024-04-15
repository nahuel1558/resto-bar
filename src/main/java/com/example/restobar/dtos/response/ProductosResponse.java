package com.example.restobar.dtos.response;

import com.example.restobar.dtos.response.ProductoResponse;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Builder
@Data
public class ProductosResponse {
    private List<ProductoResponse> productos;
}
