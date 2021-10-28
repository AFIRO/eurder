package com.switchfully.eurder.mappers;

import com.switchfully.eurder.dto.CreateItemGroupDTO;
import com.switchfully.eurder.dto.CreateOrderDTO;
import com.switchfully.eurder.dto.ItemGroupDTO;
import com.switchfully.eurder.dto.OrderDTO;
import com.switchfully.eurder.entities.Item;
import com.switchfully.eurder.entities.ItemGroup;
import com.switchfully.eurder.entities.Order;
import com.switchfully.eurder.repository.CustomerRepository;
import com.switchfully.eurder.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {
    private final ItemRepository itemRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public OrderMapper(ItemRepository itemRepository, CustomerRepository customerRepository) {
        this.itemRepository = itemRepository;
        this.customerRepository = customerRepository;
    }

    public Order toOrder(CreateOrderDTO dto) {
        List<ItemGroup> orderedItems = dto.getOrderedItems().stream()
                .map(this::toItemGroup)
                .collect(Collectors.toList());

        return new Order(itemRepository)
                .setCustomer(customerRepository.getSpecificUser(dto.getCustomerId()))
                .addListOfItemGroupToOrder(orderedItems);
    }

    public OrderDTO toOrderDTO(Order order){
        return new OrderDTO()
                .setId(order.getId())
                .setCustomer(order.getCustomer())
                .setOrderedItems(order.getOrderedItems())
                .setTotalPrice(order.getTotalPrice());
    }

    public ItemGroup toItemGroup(CreateItemGroupDTO dto){
        Item itemToAdd = itemRepository.getItem(dto.getItemId());
        return new ItemGroup(itemToAdd,Integer.parseInt(dto.getAmountToOrder()));
    }

}