package com.techelevator.view;

import java.math.BigDecimal;

public class Chip extends Products{

    public Chip(String slotLocation, String name, BigDecimal price, String type, int quantity) {
        super(slotLocation, name, price, type, quantity);
    }

    public Chip(String name, BigDecimal price, String type){
        super(name, price, type);
    }

    @Override
    public String getSound() {
        return "Crunch Crunch, It's Yummy!";
    }
}
