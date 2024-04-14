package com.example.restobar.repositories;

import com.example.restobar.models.Item;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends BaseRepository<Item, Long>{
}
