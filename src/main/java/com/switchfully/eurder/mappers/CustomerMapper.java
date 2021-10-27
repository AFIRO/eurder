package com.switchfully.eurder.mappers;

import com.switchfully.eurder.dto.createUserDTO;
import com.switchfully.eurder.dto.userDTO;
import com.switchfully.eurder.entities.User;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public User toUser(createUserDTO dto) {
        return new User(dto.getFirstName(), dto.getLastName(), dto.getEmail(), dto.getAddress(), dto.getPhoneNumber());
    }

    public userDTO toDTO(User user) {
        return new userDTO()
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setAddress(user.getAddress())
                .setEmail(user.getEmail())
                .setPhoneNumber(user.getPhoneNumber())
                .setId(user.getId());
    }
}
