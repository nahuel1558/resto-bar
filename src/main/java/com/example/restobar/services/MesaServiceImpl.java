package com.example.restobar.services;

import com.example.restobar.models.Mesa;
import com.example.restobar.repositories.BaseRepository;
import com.example.restobar.repositories.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class MesaServiceImpl extends BaseServiceImple<Mesa, Long> implements MesaService{

    @Autowired
    private MesaRepository mesaRepository;

    public MesaServiceImpl(BaseRepository<Mesa, Long> baseRepository){super (baseRepository);}

}
