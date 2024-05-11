package com.example.restobar.controllers;

import com.example.restobar.dtos.request.MesaRequest;
import com.example.restobar.dtos.response.MesasResponse;
import com.example.restobar.mappers.MesaMapper;
import com.example.restobar.models.Mesa;
import com.example.restobar.services.MesaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping(path = "/mesas")
public class MesaController extends BaseControllerImpl<Mesa, MesaServiceImpl>{

    @Autowired
    private MesaServiceImpl mesaService;

    @Autowired
    private MesaMapper mesaMapper;

    @PostMapping("/nuevaMesa")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity nuevaMesa (@RequestBody MesaRequest mesaRequest) {
        try {
            Mesa mesa = mesaMapper.mesaRequestToMesa(mesaRequest);

            return ResponseEntity.status(HttpStatus.CREATED).body(mesaService.save(mesa));
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al crear mesa. Error: " + exception.getMessage());
        }
    }
    @PutMapping("/actualizarMesa/{id}")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity actualizarProducto(@PathVariable("id") Long id, @RequestBody MesaRequest mesaRequest){
        try{
            Mesa mesa = mesaMapper.mesaRequestToMesa(mesaRequest);
            Mesa mesaGuardado = mesaService.update(id,mesa);
            return ResponseEntity.status(HttpStatus.OK).body(mesaGuardado);
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al actualizar mesa. Error: " + exception.getMessage());
        }

    }

    @GetMapping("/mostrarMesa/{id}")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> mostrarProducto(@PathVariable("id") Long id){
        try{
            return ResponseEntity.status(HttpStatus.FOUND).body(mesaService.findById(id));
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al mostrar mesa. Error:" + exception.getMessage());
        }

    }
    @GetMapping("/listarMesa")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> listarMesas(){
        try {
            List<Mesa> mesas = mesaService.findAll();
            MesasResponse mesasResponse = mesaMapper.mesaListToResponse(mesas);
            return ResponseEntity.status(HttpStatus.OK).body(mesasResponse);

        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al actualizar mesa. Error:" + exception.getMessage());
        }
    }

    @DeleteMapping("/borrarMesa/{id}")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity borrarMesa(@PathVariable("id") Long id) throws SQLException {
        try{
            mesaService.delete(id);
            return ResponseEntity.ok("Mesa Eliminado");
        }
        catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo eliminar mesa. Error: " + exception.getMessage());
        }
    }
}
