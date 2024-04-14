package com.example.restobar.services;

import com.example.restobar.models.Item;
import com.example.restobar.repositories.ItemRepository;
import com.example.restobar.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl extends BaseServiceImple<Item, Long>  implements ItemService{
    @Autowired
    private ItemRepository itemRepository;

    public ItemServiceImpl(BaseRepository<Item, Long> baseRepository){super(baseRepository);}
}
