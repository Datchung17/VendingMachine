package com.techelevator.view;

import java.math.BigDecimal;

public class Drink extends Products{

    public Drink(String slotLocation, String name, BigDecimal price, String type, int quantity) {
        super(slotLocation, name, price, type, quantity);
    }

    public Drink(String name, BigDecimal price, String type){
        super(name, price, type);

    }

    @Override
    public String getSound(){
        return "Glug Glug, Chug Chug!";
    }
}
