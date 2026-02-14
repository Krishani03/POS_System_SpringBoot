package com.ijse.gdse73.backend.service.custom.impl;

import com.ijse.gdse73.backend.dto.ItemDTO;
import com.ijse.gdse73.backend.entity.Item;
import com.ijse.gdse73.backend.exception.CustomException;
import com.ijse.gdse73.backend.repository.ItemRepository;
import com.ijse.gdse73.backend.service.custom.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    public void saveItem(ItemDTO itemDTO) {

        Item lastItem = itemRepository.findTopByOrderByIdDesc();

        String newId;

        if (lastItem == null) {
            newId = "I001";
        } else {
            int number = Integer.parseInt(lastItem.getId().substring(1));
            number++;
            newId = String.format("I%03d", number);
        }

        itemDTO.setId(newId);

        itemRepository.save(new Item(
                itemDTO.getId(),
                itemDTO.getName(),
                itemDTO.getQty(),
                itemDTO.getPrice()
        ));
    }

    @Override
    public void updateItem(ItemDTO itemDTO) {

        if (itemDTO.getId() == null || itemDTO.getId().isEmpty()) {
            throw new CustomException("Item ID required for update");
        }

        if (!itemRepository.existsById(itemDTO.getId())) {
            throw new CustomException("Item not found");
        }

        itemRepository.save(new Item(
                itemDTO.getId(),
                itemDTO.getName(),
                itemDTO.getQty(),
                itemDTO.getPrice()
        ));
    }

    @Override
    public void deleteItem(String id) {

        if (!itemRepository.existsById(id)) {
            throw new CustomException("Item not found");
        }

        itemRepository.deleteById(id);
    }

    @Override
    public List<ItemDTO> getAllItems() {

        return itemRepository.findAll()
                .stream()
                .map(item -> new ItemDTO(
                        item.getId(),
                        item.getName(),
                        item.getQty(),
                        item.getPrice()
                ))
                .toList();
    }

    @Override
    public ItemDTO getItemById(String id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new CustomException("Item not found"));

        return new ItemDTO(
                item.getId(),
                item.getName(),
                item.getQty(),
                item.getPrice()
        );
    }

    @Override
    public void reduceStock(String itemId, int qty) {

        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new CustomException("Item not found"));

        if (item.getQty() < qty) {
            throw new CustomException("Insufficient stock");
        }

        item.setQty(item.getQty() - qty);
        itemRepository.save(item);
    }
}
