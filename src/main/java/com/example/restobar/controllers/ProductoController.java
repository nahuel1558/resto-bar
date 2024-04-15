package com.example.restobar.controllers;

import com.example.restobar.models.Producto;
import com.example.restobar.services.ProductoServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@CrossOrigin(origins = "*")
@Controller
@RequestMapping(path = "/productos")
public class ProductoController  extends BaseControllerImpl<Producto, ProductoServiceImpl>{

    /*@Autowired
    private ProductoService productoService;

    @PostMapping("/nuevoProducto")
    @Produces (MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity nuevoProducto(@RequestBody ProductoRequest productoRequest){
        return productoService.newProducto(productoRequest);
    }

    @PutMapping("/actualizarProducto/{id}")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity actualizarProducto(@PathVariable("id") Long id, @RequestBody ProductoRequest productoRequest){
        return productoService.updateProducto(productoRequest, id);
    }

    @PutMapping("/actulizarProducto")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity actualizarProductoPorNombre(@RequestBody ProductoRequest productoRequest){
        return productoService.updateProductoByNombre(productoRequest);
    }

    @GetMapping("/listarProductos")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ProductosResponse listarProductos(){
        return productoService.listarProductos();
    }

    @DeleteMapping("/borrarProducto/{id}")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity borrarProducto(@PathVariable("id") Long id) throws SQLException{
        try{
            productoService.deleteProducto(id);
            return ResponseEntity.ok("Producto Eliminado");
        }

        catch (Exception exception){
            return ResponseEntity.badRequest().body("No se pudo eliminar el producto. Error: " + exception.getMessage());
        }
    }*/
}
