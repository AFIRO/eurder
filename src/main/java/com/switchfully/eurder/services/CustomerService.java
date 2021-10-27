package com.switchfully.eurder.services;

import com.switchfully.eurder.api.CustomerController;
import com.switchfully.eurder.dto.createUserDTO;
import com.switchfully.eurder.dto.userDTO;
import com.switchfully.eurder.entities.User;
import com.switchfully.eurder.mappers.CustomerMapper;
import com.switchfully.eurder.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;
    private final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    public CustomerService(CustomerMapper customerMapper, CustomerRepository customerRepository) {
        this.customerMapper = customerMapper;
        this.customerRepository = customerRepository;
    }

    public userDTO saveNewUser(createUserDTO dto) {
        if (isValidInput(dto.getFirstName()) && isValidInput(dto.getLastName()) && isValidInput(dto.getAdress()) && isValidInput(dto.getEmail()) && isValidInput(dto.getPhoneNumber())) {
            User newUser = customerMapper.toUser(dto);
            customerRepository.saveUser(newUser);
            logger.info("User with the following id has been created: " + newUser.getId());
            return customerMapper.toDTO(newUser);
        }
        else
            throw new IllegalArgumentException("The parameters supplied for your user account are not valid");
    }


    public boolean isValidInput(String input){
        return  !(input == null || input.isEmpty() || input.isBlank());
    }
}
