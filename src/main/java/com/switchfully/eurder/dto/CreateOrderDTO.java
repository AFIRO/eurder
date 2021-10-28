package com.switchfully.eurder.dto;

import com.switchfully.eurder.entities.ItemGroup;
import com.switchfully.eurder.entities.User;
import com.switchfully.eurder.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CreateOrderDTO {
    private List<CreateItemGroupDTO> orderedItems;
    private String customerId;


    public CreateOrderDTO setCustomer(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public CreateOrderDTO setOrderedItems(List<CreateItemGroupDTO> orderedItems) {
        this.orderedItems = orderedItems;
        return this;
    }

    public List<CreateItemGroupDTO> getOrderedItems() {
        return orderedItems;
    }

    public String getCustomerId() {
        return customerId;
    }

}
