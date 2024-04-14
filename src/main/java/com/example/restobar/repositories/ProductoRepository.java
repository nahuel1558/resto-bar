package com.example.restobar.repositories;

import com.example.restobar.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ProductoRepository extends BaseRepository<Producto, Long>{

    }


