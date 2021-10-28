package com.switchfully.eurder.repository;

import com.switchfully.eurder.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class OrderRepository {
    private final Map<String,Order> ordersByOrderId;

    @Autowired
    public OrderRepository() {
        this.ordersByOrderId = new ConcurrentHashMap<>();
    }


    public void saveOrder(Order newOrder) {
        ordersByOrderId.put(newOrder.getId(),newOrder);
    }

    public Order getSpecificOrder(String orderId) {
        if (ordersByOrderId.containsKey(orderId))
            return ordersByOrderId.get(orderId);
        else
            throw new NoSuchElementException("The order requested does not exist");
    }
}
