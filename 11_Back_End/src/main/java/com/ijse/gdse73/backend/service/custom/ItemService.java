package com.ijse.gdse73.backend.service.custom;

import com.ijse.gdse73.backend.dto.ItemDTO;
import java.util.List;

public interface ItemService {
    void saveItem(ItemDTO itemDTO);
    void updateItem(ItemDTO itemDTO);
    void deleteItem(String id);
    List<ItemDTO> getAllItems();

    // New methods
    ItemDTO getItemById(String id);
    void reduceStock(String itemId, int qty);
}
