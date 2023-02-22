package com.techelevator.view;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class PurchaseMenu {
    private BigDecimal balance = new BigDecimal("0.00");
    private int castedAmount;
    private String userSlotInput;
    Scanner scanner = new Scanner(System.in);
    private ItemMenu itemMenu;


    public void feedMoney(PurchaseMenu purchaseMenu) {
        System.out.println("Input amount of Dollars");
        castedAmount = Integer.valueOf(scanner.nextLine());
        if(castedAmount > 0) {
            balance = BigDecimal.valueOf(castedAmount);
//        System.out.println("Balance: $" + balance);
            purchaseMenu.setBalance(balance);
        }else{
            System.out.println("Deposit has to be more than 0!!");
        }
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void selectProduct(Map<String, Products> inventory, PurchaseMenu purchaseMenu) {

        System.out.println("Choose Item Product");
        try{
            userSlotInput = scanner.nextLine().toUpperCase();
            for(Map.Entry<String, Products> x : inventory.entrySet()){
                if(userSlotInput.equals(x.getKey())) {
                    if (balance.compareTo(BigDecimal.ZERO) <= 0) {
                        System.out.println("NO BALANCE!");
                    } else {
                        if (x.getValue().getQuantity() != 0) {
                            x.getValue().setQuantity(x.getValue().getQuantity() - 1);
                            purchaseMenu.setBalance(balance.subtract(x.getValue().getPrice()));
                            System.out.println("Item Dispensed: " + x.getValue().getName() + "\n" + "Item Quantity: " + x.getValue().getQuantity() + "\n"  + x.getValue().getSound());
                        } else {
                            System.out.println("Sold Out!");
                        }
                    }
                }

        }

        } catch (Exception e) {

        }
    }
}

