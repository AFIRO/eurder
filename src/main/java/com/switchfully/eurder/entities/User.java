package com.switchfully.eurder.entities;

import java.util.UUID;

public class User {
    private final String id;
    private  final String firstName;
    private final String lastName;
    private final String email;
    private final String adress;
    private final String phoneNumber;
    private boolean isAdmin;


    public User(String firstName, String lastName, String email, String adress, String phoneNumber) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.adress = adress;
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

    public String getAdress() {
        return adress;
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
