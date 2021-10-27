package com.switchfully.eurder.dto;

public class ItemDTO {

    private String id;
    private String name;
    private String Description;
    private double price;
    private int amountInStock;


    public ItemDTO setName(String name) {
        this.name = name;
        return this;
    }

    public ItemDTO setDescription(String description) {
        Description = description;
        return this;
    }

    public ItemDTO setPrice(double price) {
        this.price = price;
        return this;
    }

    public ItemDTO setAmountInStock(int amountInStock) {
        this.amountInStock = amountInStock;
        return this;
    }

    public ItemDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return Description;
    }

    public double getPrice() {
        return price;
    }

    public double getAmountInStock() {
        return amountInStock;
    }

    public String getId() {
        return id;
    }

}
