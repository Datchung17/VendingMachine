package com.techelevator.view;

import java.math.BigDecimal;

public class CoinBox {
    private BigDecimal bigQuarter = new BigDecimal(".25");
    private BigDecimal bigDime = new BigDecimal(".10");
    private BigDecimal bigNickel = new BigDecimal(".05");
    private BigDecimal bigPenny = new BigDecimal(".01");


    public void returnChange(BigDecimal balance, PurchaseMenu purchaseMenu){
        int quarter = 0;
        int dime = 0;
        int nickel = 0;
        int penny = 0;
        while (balance.compareTo(BigDecimal.ZERO) == 1) {
            while(balance.compareTo(bigQuarter)>= 0){
                balance = balance.subtract(bigQuarter);
                quarter++;
            }
            while(balance.compareTo(bigDime) >=0){
                balance = balance.subtract(bigDime);
                dime++;
            }
            while(balance.compareTo(bigNickel)>=0){
                balance = balance.subtract(bigNickel);
                nickel++;
            }
            while(balance.compareTo(bigPenny)>=0){
                balance = balance.subtract(bigPenny);
                penny++;
            }

        }
        System.out.println("Quarters: " + quarter + "\n" + "Dimes: " + dime + "\n" + "Nickels: " + nickel + "\n" + "Pennies: " + penny);
        purchaseMenu.setBalance(balance);
    }
}
