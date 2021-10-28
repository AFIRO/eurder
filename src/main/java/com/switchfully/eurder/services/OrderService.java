package com.switchfully.eurder.services;

import com.switchfully.eurder.dto.CreateOrderDTO;
import com.switchfully.eurder.dto.OrderDTO;
import com.switchfully.eurder.entities.Order;
import com.switchfully.eurder.mappers.OrderMapper;
import com.switchfully.eurder.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final ValidationService validationService;
    private final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    public OrderService(OrderMapper orderMapper, OrderRepository orderRepository, ValidationService validationService) {
        this.orderMapper = orderMapper;
        this.orderRepository = orderRepository;
        this.validationService = validationService;
    }

    public OrderDTO createNewOrder(String customerId, CreateOrderDTO dto) {
        if (validationService.isValidCreateOrderDTO(dto)) {
            Order newOrder = orderMapper.toOrder(dto);
            orderRepository.saveOrder(newOrder);
            logger.info("Order with id " + newOrder.getId() + " saved");
            return orderMapper.toOrderDTO(newOrder);
        } else
            throw new IllegalArgumentException("The parameters for your order are invalid");
    }
}
