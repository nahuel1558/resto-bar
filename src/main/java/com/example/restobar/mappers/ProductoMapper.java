package com.example.restobar.mappers;

import com.example.restobar.dtos.request.ProductoRequest;
import com.example.restobar.dtos.response.ProductoResponse;
import com.example.restobar.dtos.response.ProductosResponse;
import com.example.restobar.models.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoMapper {
    public Producto productoRequestToProducto(ProductoRequest productoRequest){
        Producto producto = Producto.builder()
                .nombre(productoRequest.getNombre())
                .descripcion(productoRequest.getDescripcion())
                .costo(productoRequest.getCosto())
                .precio(productoRequest.getPrecio())
                .build();
        return producto;
    }

    public ProductosResponse productoListToResponse(List<Producto> productos) {
        List<ProductoResponse> productoResponseList = new ArrayList<>();

        for (Producto producto : productos){
            ProductoResponse productoResponse = ProductoResponse.builder()
                .nombre(producto.getNombre())
                .descripcion(producto.getDescripcion())
                .costo(producto.getCosto())
                .precio(producto.getPrecio())
                .build();
    }

    ProductosResponse productosResponse = ProductosResponse.builder()
            .productos(productoResponseList)
            .build();
        return productosResponse;
    }
}