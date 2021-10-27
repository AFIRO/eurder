package com.switchfully.eurder.mappers;

import com.switchfully.eurder.dto.CreateItemDTO;
import com.switchfully.eurder.dto.ItemDTO;
import com.switchfully.eurder.entities.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {
    public Item toItem(CreateItemDTO dto) {
        return new Item()
                .setName(dto.getName())
                .setDescription(dto.getDescription())
                .setPrice(Double.parseDouble(dto.getPrice()))
                .setAmountInStock(Integer.parseInt(dto.getAmountInStock()));
    }

    public ItemDTO toDTO(Item item) {
        return new ItemDTO()
                .setId(item.getId())
                .setName(item.getName())
                .setDescription(item.getDescription())
                .setPrice(item.getPrice())
                .setAmountInStock(item.getAmountInStock());
    }
}
