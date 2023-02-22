package com.techelevator.view;

import java.math.BigDecimal;

public class Gum extends Products{


    public Gum(String slotLocation, String name, BigDecimal price, String type, int quantity) {
        super(slotLocation, name, price, type, quantity);
    }

    public Gum(String name, BigDecimal price, String type){
        super(name, price, type);
    }

    @Override
    public String getSound(){
        return "Chew Chew, Pop!";
    }
}
