package com.switchfully.eurder.services;

import com.switchfully.eurder.dto.createUserDTO;
import com.switchfully.eurder.dto.userDTO;
import com.switchfully.eurder.entities.User;
import com.switchfully.eurder.exceptions.AuthorisationException;
import com.switchfully.eurder.mappers.CustomerMapper;
import com.switchfully.eurder.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        if (isValidDTO(dto)) {
            User newUser = customerMapper.toUser(dto);
            customerRepository.saveUser(newUser);
            logger.info("User with the following id has been created: " + newUser.getId());
            return customerMapper.toDTO(newUser);
        } else
            throw new IllegalArgumentException("The parameters supplied for your user account are not valid");
    }

    public userDTO saveNewAdmin(String authorisationId, createUserDTO dto) {
        assertAdmin(authorisationId);
        if (isValidDTO(dto)) {
            User newUser = customerMapper.toUser(dto);
            newUser.setAdmin(true);
            customerRepository.saveUser(newUser);
            logger.info("User with the following id has been created: " + newUser.getId());
            return customerMapper.toDTO(newUser);
        } else
            throw new IllegalArgumentException("The parameters supplied for your user account are not valid");

    }


    public List<userDTO> getAllUsers(String id) {
        assertAdmin(id);
        return customerRepository.getSavedUsersById().values().stream()
                .map(customerMapper::toDTO)
                .collect(Collectors.toList());
    }


    public userDTO getSpecificUser(String authorisationId, String customerId) {
        assertAdmin(authorisationId);
        return customerMapper.toDTO(customerRepository.getSpecificUser(customerId));
    }


    public boolean isValidInput(String input) {
        return !(input == null || input.isEmpty() || input.isBlank());
    }

    public boolean isValidDTO(createUserDTO dto){
        return  isValidInput(dto.getFirstName()) && isValidInput(dto.getLastName()) && isValidInput(dto.getAddress()) && isValidInput(dto.getEmail()) && isValidInput(dto.getPhoneNumber());
    }

    public void assertAdmin(String id) {
        List<String> toValidateAgainst =
                customerRepository
                        .getSavedUsersById()
                        .values()
                        .stream()
                        .filter(User::isAdmin)
                        .map(User::getId)
                        .collect(Collectors.toList());
        if (!toValidateAgainst.contains(id))
            throw new AuthorisationException();
    }

}
