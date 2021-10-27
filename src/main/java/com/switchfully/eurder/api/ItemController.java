package com.switchfully.eurder.api;

import com.switchfully.eurder.dto.CreateItemDTO;
import com.switchfully.eurder.dto.ItemDTO;
import com.switchfully.eurder.services.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;
    private final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping(produces = "application/json", consumes = "application/json", params = "authorisationId")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDTO createItem(@RequestParam(value = "authorisationId") String authorisationId, @RequestBody CreateItemDTO dto) {
        return itemService.createNewItem(authorisationId,dto);
    }

    @GetMapping(produces = "application/json", params = "authorisationId")
    @ResponseStatus(HttpStatus.OK)
    public List<ItemDTO> getAllItemsByStock(@RequestParam(value = "authorisationId") String authorisationId) {
        return itemService.getAllItemsByStock(authorisationId);
    }

    @GetMapping(produces = "application/json", params = {"authorisationId","urgency"})
    @ResponseStatus(HttpStatus.OK)
    public List<ItemDTO> getItemsByUrgency(@RequestParam(value = "authorisationId") String authorisationId, @RequestParam(value = "urgency", required = false) String urgency) {
        return itemService.getItemsByUrgency(authorisationId, urgency);
    }

}
