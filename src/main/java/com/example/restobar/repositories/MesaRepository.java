package com.example.restobar.repositories;

import com.example.restobar.models.Mesa;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MesaRepository extends BaseRepository<Mesa, Long>{
    Optional<Mesa> findByNombre(Mesa mesa);
}
