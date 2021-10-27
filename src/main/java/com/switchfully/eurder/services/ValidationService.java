package com.switchfully.eurder.services;

import com.switchfully.eurder.dto.CreateItemDTO;
import com.switchfully.eurder.dto.createUserDTO;
import com.switchfully.eurder.entities.User;
import com.switchfully.eurder.exceptions.AuthorisationException;
import com.switchfully.eurder.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ValidationService {
    private final CustomerRepository customerRepository;

    @Autowired
    public ValidationService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public boolean isValidStringInput(String input) {
        return !(input == null || input.isEmpty() || input.isBlank());
    }

    public boolean isValidDoubleInput(String number) {
        try {
            Double.parseDouble(number);
            return true;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("The parameter for the price is not valid.");
        }
    }

    public boolean isValidIntegerInput(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("The parameter for the price is not valid.");
        }
    }

    public boolean IsValidCreateUserDTO(createUserDTO dto) {
        return isValidStringInput(dto.getFirstName())
                && isValidStringInput(dto.getLastName())
                && isValidStringInput(dto.getAddress())
                && isValidStringInput(dto.getEmail())
                && isValidStringInput(dto.getPhoneNumber());
    }

    public boolean isValidCreateItemDTO(CreateItemDTO dto) {
        return isValidStringInput(dto.getName())
                && isValidStringInput(dto.getDescription())
                && isValidDoubleInput(dto.getPrice())
                && isValidIntegerInput(dto.getAmountInStock());

    }

    public void assertAdmin(String id) {
        List<String> toValidateAgainst =
                customerRepository
                        .getAllUsers()
                        .values()
                        .stream()
                        .filter(User::isAdmin)
                        .map(User::getId)
                        .collect(Collectors.toList());
        if (!toValidateAgainst.contains(id))
            throw new AuthorisationException();
    }


}
