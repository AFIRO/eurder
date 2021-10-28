package com.switchfully.eurder.dto;

import com.switchfully.eurder.entities.ItemGroup;
import com.switchfully.eurder.entities.User;

import java.util.List;

public class OrderDTO {
    private String id;
    private User customer;
    private List<ItemGroup> orderedItems;
    private double totalPrice;



    public OrderDTO setCustomer(User customer) {
        this.customer = customer;
        return this;
    }

    public OrderDTO setId(String id) {
        this.id = id;
        return this;
    }

    public OrderDTO setOrderedItems(List<ItemGroup> orderedItems) {
        this.orderedItems = orderedItems;
        return this;
    }

    public OrderDTO setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    public List<ItemGroup> getOrderedItems() {
        return orderedItems;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public User getCustomer() {
        return customer;
    }

    public String getId() {
        return id;
    }
}
