package com.example.restobar.controllers;

import com.example.restobar.dtos.request.ProductoRequest;
import com.example.restobar.dtos.response.ProductosResponse;
import com.example.restobar.mappers.ProductoMapper;
import com.example.restobar.models.Producto;
import com.example.restobar.services.ProductoService;
import com.example.restobar.services.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import java.sql.SQLException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@Controller
@RequestMapping(path = "/productos")
public class ProductoController  extends BaseControllerImpl<Producto, ProductoServiceImpl> {

    @Autowired
    private ProductoServiceImpl productoService;

    @Autowired
    private ProductoMapper productoMapper;

    @PostMapping("/nuevoProducto")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity nuevoProducto (@RequestBody ProductoRequest productoRequest) {
        try {
            Producto producto = productoMapper.productoRequestToProducto(productoRequest);
            //Producto productoGuardado = productoService.save(producto);

            return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(producto));
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al crear el producto. Error: " + exception.getMessage());
        }
    }
    @PutMapping("/actualizarProducto/{id}")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity actualizarProducto(@PathVariable("id") Long id, @RequestBody ProductoRequest productoRequest){
        try{
            Producto producto = productoMapper.productoRequestToProducto(productoRequest);
            Producto productoGuardado = productoService.update(id,producto);
            return ResponseEntity.status(HttpStatus.OK).body(productoGuardado);
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al actualizar el producto. Error: " + exception.getMessage());
        }

    }

    @GetMapping("/mostrarProducto/{id}")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> mostrarProducto(@PathVariable("id") Long id){
        try{
            //Producto producto = productoService.findById(id);
            return ResponseEntity.status(HttpStatus.FOUND).body(productoService.findById(id));
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al mostrar el producto. Error:" + exception.getMessage());
        }

    }
    @GetMapping("/listarProductos")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> listarProductos(){
        try {
            List<Producto> productos = productoService.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(productos);
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al actualizar el producto. Error:" + exception.getMessage());
        }
    }

    @DeleteMapping("/borrarProducto/{id}")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity borrarProducto(@PathVariable("id") Long id) throws SQLException {
        try{
            productoService.delete(id);
            return ResponseEntity.ok("Producto Eliminado");
        }
        catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo eliminar el producto. Error: " + exception.getMessage());
        }
    }
}
