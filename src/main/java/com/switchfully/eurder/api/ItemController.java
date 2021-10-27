package com.switchfully.eurder.api;

import com.switchfully.eurder.services.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;
    private final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }
}
