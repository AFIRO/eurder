package com.switchfully.eurder.entities;



import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.UUID;


public class User {
    private final String id;
    @NotBlank(message = "First name must be filled in")
    private  final String firstName;
    @NotBlank(message = "Last name must be filled in")
    private final String lastName;
    @NotBlank(message = "Email must be filled in")
    @Email(message = "Email is not valid")
    private final String email;
    @NotBlank(message = "Address must be filled in")
    private final String address;
    @NotBlank(message = "Phone number must be filled in")
    private final String phoneNumber;
    private boolean isAdmin;


    public User(String firstName, String lastName, String email, String address, String phoneNumber) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getId() {
        return id;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public User setAdmin(boolean admin) {
        isAdmin = admin;
        return this;
    }
}
