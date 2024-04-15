package com.example.restobar.services;

import com.example.restobar.models.Producto;
import com.example.restobar.repositories.ProductoRepository;
import com.example.restobar.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Clase de implementacion que extiende de la clase BaseService implememntada, con los parametros del Producto
//a su vez implementa el ProductoService
@Service
public class ProductoServiceImpl extends BaseServiceImple<Producto, Long> implements ProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    public ProductoServiceImpl(BaseRepository<Producto, Long> baseRepository){
        super(baseRepository);
    }
}