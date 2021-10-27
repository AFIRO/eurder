package com.switchfully.eurder.dto;

public class userDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phoneNumber;

    public userDTO setId(String id) {
        this.id = id;
        return this;
    }

    public userDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public userDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public userDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public userDTO setAddress(String address) {
        this.address = address;
        return this;
    }

    public userDTO setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getId() {
        return id;
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
}
