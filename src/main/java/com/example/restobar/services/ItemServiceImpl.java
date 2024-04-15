package com.example.restobar.services;

import com.example.restobar.models.Item;
import com.example.restobar.models.Producto;
import com.example.restobar.repositories.ItemRepository;
import com.example.restobar.repositories.BaseRepository;
import com.example.restobar.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemServiceImpl extends BaseServiceImple<Item, Long>  implements ItemService{


    private ItemRepository itemRepository;
    private ProductoRepository productoRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, ProductoRepository productoRepository) {
        super(itemRepository);
        this.itemRepository = itemRepository;
        this.productoRepository = productoRepository;
    }
    @Override
    @Transactional
    public Item crearItemConProducto(Item items) throws Exception {
        try {
            // Buscar el producto por su ID
            float cantidad = items.getCantidad();
            Producto producto = items.getProducto();
            //Producto producto = productoRepository.findById(idProducto)
                    //.orElseThrow(() -> new Exception("Producto no encontrado"));
            // Crear un nuevo ítem
            Item item = new Item();
            // Configurar el producto y la cantidad en el ítem

            item.setProducto(producto);
            item.setCantidad(cantidad);
            // Calcular el precio total
            Float precioProdducto = producto.getPrecio();
            Float precioTotal = cantidad * precioProdducto;
            item.setPrecioTotal(precioTotal);

            // Guardar el ítem en la base de datos
            return itemRepository.save(item);
        } catch (Exception e) {
            throw new Exception("Error al crear el ítem: " + e.getMessage());
        }
    }

    public ItemServiceImpl(BaseRepository<Item, Long> baseRepository){super(baseRepository);}
}
