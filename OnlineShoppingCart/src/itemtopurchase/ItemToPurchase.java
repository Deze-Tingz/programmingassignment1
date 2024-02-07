/*Author: Val I. John
Course: 9.1 LAB* (H): Program: Online shopping cart (Part 1)
Date: October 24th 2023
Assignment: Online shopping cart (Part 1)
Instructor: Sergio Pisano
Description: In main(), prompt the user for two items and create two objects of the ItemToPurchase class. 
Before prompting for the second item, call scnr.nextLine(); to allow the user to input a new string.
 */

//package itemtopurchase;

//Class Definition
public class ItemToPurchase {
	// Private member variables for item name, price, and quantity
	private String itemName;
	private int itemPrice;
	private int itemQuantity;

	// Default constructor initializes the member variables with default values
	public ItemToPurchase() {
		this.itemName = "none";
		this.itemPrice = 0;
		this.itemQuantity = 0;
	}

	// Setter method to set the name of the item
	public void setName(String name) {
		this.itemName = name;
	}

	// Getter method to retrieve the name of the item
	public String getName() {
		return itemName;
	}

	// Setter method to set the price of the item
	public void setPrice(int price) {
		itemPrice = price;
	}

	// Getter method to retrieve the price of the item
	public int getPrice() {
		return itemPrice;
	}

	// Setter method to set the quantity of the item
	public void setQuantity(int quantity) {
		itemQuantity = quantity;
	}

	// Getter method to retrieve the quantity of the item
	public int getQuantity() {
		return itemQuantity;
	}

	// Method to calculate and display the total cost of the item
	public void itemTotalCost(String itemName, int itemQuantity, int itemPrice, int totalCost) {
		totalCost = itemPrice * itemQuantity;

		System.out.println(itemName + " " + itemQuantity + " @ " + "$" + itemPrice + " = " + "$"+totalCost);
	}

}
