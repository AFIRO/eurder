package com.switchfully.eurder.api;

import com.switchfully.eurder.dto.createUserDTO;
import com.switchfully.eurder.dto.userDTO;
import com.switchfully.eurder.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Customer")
public class CustomerController {
    private final CustomerService customerService;
    private final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public userDTO createUser(@RequestBody createUserDTO dto){
        logger.info("New user creation called");
        return customerService.saveNewUser(dto);

    }
}
