package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class ItemMenu {
    private Map<String, Products> inventoryMap = new TreeMap<>();


    //method reads the csv file and will split the text into a String Array, after we will take each element and use switch statement to populate map
    public Map<String, Products> makeMap() {
        String itemDisplayFile = "vendingmachine.csv";
        File itemDisplay = new File(itemDisplayFile);

        //Instantiate a Map

        try (Scanner itemScanner = new Scanner(itemDisplay)) {

            while (itemScanner.hasNextLine()) {
                String itemLine = itemScanner.nextLine();

                //Populate Array with item list
                String[] itemArray = itemLine.split("\\|");
                String slot = itemArray[0];
                String name = itemArray[1];
                String intPrice = itemArray[2];
                String type = itemArray[3];
                BigDecimal price = new BigDecimal(intPrice);

                //Populate Map with switch statement, depending on the item type that it's iterating through
                switch (type) {
                    case "Chip":
                        Chip chip = new Chip(name, price, type);
                        inventoryMap.put(slot, chip);
                        break;
                    case "Candy":
                        Candy candy = new Candy(name, price, type);
                        inventoryMap.put(slot, candy);
                        break;
                    case "Drink":
                        Drink drink = new Drink(name, price, type);
                        inventoryMap.put(slot, drink);
                        break;
                    case "Gum":
                        Gum gum = new Gum(name, price, type);
                        inventoryMap.put(slot, gum);
                        break;
                    default:
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return inventoryMap;
    }

    public void displayProducts(Map<String, Products> map) {
        System.out.printf("\n%-5s %-20s %-15s %-10s \n\n", "Slot", "Product", "Price", "Inventory Count");
        for (Map.Entry<String, Products> x : map.entrySet()) {
            System.out.printf("%-5s %-20s %-15s %-10s \n", x.getKey(), x.getValue().getName(), x.getValue().getPrice(), x.getValue().getQuantity());
        }
    }

    public Map<String, Products> getInventoryMap(){
        return inventoryMap;
    }
}





//    public void displayInventory() {
//        String itemDisplayFile = "vendingmachine.csv";
//        File itemDisplay = new File(itemDisplayFile);
//
//        try (Scanner itemScanner = new Scanner(itemDisplay)) {
//            System.out.printf("Slot" + " " + "Item" + " " + "Price" + "\n");
//            while (itemScanner.hasNextLine()) {
//                String itemLine = itemScanner.nextLine();
//
//                //Populate Array with item list
//                String[] itemArray = itemLine.split("\\|");
//                for (int i = 0; i < itemArray.length; i += 4) {
//                    System.out.println(itemArray[i] + " " + itemArray[i + 1] + " " + itemArray[i + 2]);
//                }
//            }
//
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//    }

//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

//                //convert String price to bigDecimal
//                BigDecimal bigDecimal = new BigDecimal(itemArray[2]);
//
//                item[count] = new Items(itemArray[0], itemArray[1], bigDecimal, itemArray[3], quantity );
//
//                itemMap.put(item[count].getSlotLocation(), item[count]);
//                count++;