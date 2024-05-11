package com.example.restobar.services;

import com.example.restobar.models.Mesa;
import com.example.restobar.repositories.BaseRepository;
import com.example.restobar.repositories.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MesaServiceImpl extends BaseServiceImple<Mesa, Long> implements MesaService{

    @Autowired
    private MesaRepository mesaRepository;
    @Override
    @Transactional
    public Mesa findByName(Mesa mesa) throws Exception {
        try{
            Optional<Mesa> mesaOptional = mesaRepository.findByNombre(mesa);
            return mesaOptional.orElse(null); // Devuelve la mesa si se encuentra, de lo contrario, devuelve null
        }catch(Exception e){
            throw new Exception("Error al buscar la mesa por nombre: " + e.getMessage());
        }
    }
    public MesaServiceImpl(BaseRepository<Mesa, Long> baseRepository){super (baseRepository);}

}
