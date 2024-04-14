package com.example.restobar.controllers;

import com.example.restobar.models.Base;
import com.example.restobar.services.BaseServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Clase Abstracta que tiene como parametros E de Base y S que extiende de BaseService
//A su vez BaseService tiene como parametro E y el tipo de dato Long
//Ademas implementa BaseController con los parametros E y Long
public abstract class BaseControllerImpl<E extends Base, S extends BaseServiceImple<E, Long>> implements BaseController<E, Long> {
    @Autowired
    protected S servicio;

    @GetMapping("/list")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, intente mas adelante\"}");
        }
    }
    @GetMapping("/one{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findById(id));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, intente mas adelante\"}");
        }
    }
    @PostMapping("/save")
    public ResponseEntity save(@RequestBody E entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.save(entity));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, intente mas adelante\"}");
        }
    }
    @PutMapping("/update{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody E entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.update(id,entity));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, intente mas adelante\"}");
        }
    }
    @DeleteMapping("/delete{id}")
    public ResponseEntity delete(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(servicio.delete(id));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, intente mas adelante\"}");
        }
    }
}