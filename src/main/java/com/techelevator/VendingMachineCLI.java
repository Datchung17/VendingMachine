package com.techelevator;

import com.techelevator.view.*;
//import com.techelevator.view.Payment;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String MAIN_MENU_SECRET_OPTION = "*Sales Report";

	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";

	private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT, MAIN_MENU_SECRET_OPTION};
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};

	private VendingMenu menu;

	ItemMenu itemMenu = new ItemMenu();
	PurchaseMenu purchaseMenu = new PurchaseMenu();
	CoinBox coinBox = new CoinBox();

	public VendingMachineCLI(VendingMenu menu) {
		this.menu = menu;
	}

	public void run() {
		boolean running = true;
		BigDecimal currentBalance = purchaseMenu.getBalance();

		//instantiate inventory map to work with
		Map<String, Products> inventory = itemMenu.makeMap();

		while (running) {

			//takes user input and will decide which direction to take
			System.out.println("Balance: $" + purchaseMenu.getBalance());
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);


			// if user chooses 1) display items, it will show the items
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items with quantity
				itemMenu.displayProducts(inventory);


				// if user chooses 2) purchase item, it will go into purchase menu
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {

				// takes another user input to decide which direction IN the purchase menu
				String choice2 = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

				// if user chooses 1) feed money, it will go into the feed money method
				if (choice2.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
					//feed money methods
					purchaseMenu.feedMoney(purchaseMenu);
					continue;

				} else if (choice2.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
					// select product method
					itemMenu.displayProducts(inventory);
					purchaseMenu.selectProduct(inventory, purchaseMenu);
					continue;
				} else if (choice2.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
					// go back to menu option
					coinBox.returnChange(purchaseMenu.getBalance(), purchaseMenu);
				}


			} else if(choice.equals(MAIN_MENU_OPTION_EXIT )){
				running = false;
				}
			}
		}

			public static void main (String[]args){
				VendingMenu menu = new VendingMenu(System.in, System.out);
				VendingMachineCLI cli = new VendingMachineCLI(menu);
				cli.run();
	}
}
