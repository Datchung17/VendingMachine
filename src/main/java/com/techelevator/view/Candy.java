package com.techelevator.view;

import java.math.BigDecimal;

public class Candy extends Products{

    public Candy(String slotLocation, String name, BigDecimal price, String type, int quantity) {
        super(slotLocation, name, price, type, quantity);
    }

        public Candy(String name, BigDecimal price, String type){
            super(name, price, type);

        }


    @Override
    public String getSound() {
        return "Munch Munch, Mmm Mmm Good!";
    }
}
