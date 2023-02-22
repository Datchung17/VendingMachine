package com.techelevator.view;

import java.math.BigDecimal;

public abstract class Products {
    private String name;
    private BigDecimal price;
    private String slotLocation;
    private String type;
    private int quantity =5;

    public Products(String slotLocation, String name, BigDecimal price, String type, int quantity){
        this.slotLocation = slotLocation;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public Products(String name, BigDecimal price, String type){
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity = quantity;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //method for purchase transaction.... getquantity() - 1;

    public String getName(){
        return name;
    }

    public BigDecimal getPrice(){
        return price;
    }

    public String getSlotLocation(){
        return slotLocation;
    }

    public String getType(){
        return type;
    }

    public abstract String getSound();
}
