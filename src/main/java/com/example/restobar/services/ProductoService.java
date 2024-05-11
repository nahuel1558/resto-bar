package com.example.restobar.services;

import com.example.restobar.mappers.ProductoMapper;
import com.example.restobar.models.Producto;
import com.example.restobar.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface ProductoService extends BaseService<Producto, Long>{
/*
    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProductoMapper productoMapper;

    @Override
    @Transactional
    public List<Producto> findAll() throws Exception {
        try{
            List<Producto> productos = productoRepository.findAll();
            return productos;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public ResponseEntity save(producto){
        Boolean existeProducto = findByNombre(productoRequest.getNombre()).isEmpty();
        if(existeProducto){
            Producto producto = productoRequestToNewProducto(productoRequest);
            saveProducto(producto);
            return ResponseEntity.ok("Producto guardado: " + producto.getNombre() + " " + producto.getDescripcion());
        }
        else{
            return ResponseEntity.badRequest().body("El producto con ese nombre ya existe.");
        }

        }

        public ResponseEntity updateProductoByNombre(ProductoRequest productoRequest){

            try{
                Producto producto = productoRepository.findByNombre(productoRequest.getNombre()).get(0);
                producto = productoRequestToExistedProducto(productoRequest);
                productoRepository.save(producto);
                return ResponseEntity.ok("Producto actualizado: " + producto.getNombre());
            }
            catch (Exception exception){
                return ResponseEntity.badRequest().body("No existe el producto con ese nombre: " + productoRequest.getNombre());
            }
        }
        public ResponseEntity updateProducto(ProductoRequest productoRequest, Long id){
            try{
                Producto producto = productoRepository.getById(id);
                producto = productoRequestToExistedProducto(productoRequest);
                productoRepository.save(producto);
                return ResponseEntity.ok("Producto Actualizado: " + producto.getNombre());
            }
            catch (Exception exception){
                return ResponseEntity.badRequest().body("No existe producto con el id: " + id);
            }
        }

        public void saveProducto(Producto producto){
        productoRepository.save(producto);
        }

        public Producto productoRequestToNewProducto(ProductoRequest productoRequest){
        return productoMapper.productoRequestToProducto(productoRequest);
        }

        public Producto productoRequestToExistedProducto(ProductoRequest productoRequest){
        return productoMapper.productoRequestToProducto(productoRequest);
        }
    public ProductosResponse listarProductos(){
        List<Producto> listaProductos = productoRepository.findAll();
        return productoMapper.productoListToResponse(listaProductos);
    }

    public List<Producto> findByNombre(String nombre){
        return productoRepository.findByNombre(nombre);
    }

    public Producto save(Producto producto){
        return productoRepository.save(producto);
    }

    public void deleteProducto(Long id){
        productoRepository.deleteById(id);
    }*/
}
