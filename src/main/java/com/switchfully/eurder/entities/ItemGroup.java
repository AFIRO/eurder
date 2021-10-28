package com.switchfully.eurder.entities;

import java.time.LocalDate;

public class ItemGroup {
    private final Item item;
    private final int amountToOrder;
    private final double costForItemGroup;
    private final LocalDate shippingDate;
    private static final Long DAYS_SHIPPING_EXTRA_IF_INSUFFICIENT_STOCK = 7L;

    public ItemGroup(Item item, int amountToOrder) {
        this.item = item;
        this.amountToOrder = amountToOrder;
        this.costForItemGroup = calculatePriceForItemGroup();
        shippingDate = calculateShippingDate();

    }

    private double calculatePriceForItemGroup() {
        return this.amountToOrder * item.getPrice();
    }

    public LocalDate calculateShippingDate(){
        if (item.getAmountInStock() >= amountToOrder)
            return LocalDate.now();
        else
            return LocalDate.now().plusDays(DAYS_SHIPPING_EXTRA_IF_INSUFFICIENT_STOCK);
    }

    public Item getItem() {
        return item;
    }

    public int getAmountToOrder() {
        return amountToOrder;
    }

    public double getCostForItemGroup() {
        return costForItemGroup;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }
}
