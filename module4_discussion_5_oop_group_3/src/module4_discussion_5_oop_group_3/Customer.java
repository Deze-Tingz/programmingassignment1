/*Author: Val I. John
Course: Module 4 | Study Group Task & Discussion 5: OOP - Group 3
Date: October 26th 2023
Assignment: Create a Java program that will implement Object Oriented basic concepts.
Instructor: Sergio Pisano
Description: Replicate in Eclipse the program explained in the video lectures showing the following classes: 
			Cars, Customer, ServiceQuote, and MyDriverClass. Place a few breakpoints at the start of the program and run it
			in debug mode step-by-step. Observe how the program progresses, the value of variables, objects, and the 
			object-oriented model at work. Make note of which section is executed first and why, etc.
 */

// Define the package for the class
package module4_discussion_5_oop_group_3;

// Define the Customer class to store and manage customer details
public class Customer {

	// Declare private variables for customer's name, address, and phone
	private String name;
	private String address;
	private String phone;

	// Method to set the customer's name
	public void setName(String n) {
		this.name = n;
	}

	// Method to set the customer's address
	public void setAddress(String a) {
		this.address = a;
	}

	// Method to set the customer's phone number
	public void setPhone(String p) {
		this.phone = p;
	}

	// Method to get the customer's name
	public String getName() {
		return this.name;
	}

	// Method to get the customer's address
	public String getAddress() {
		return this.address;
	}

	// Method to get the customer's phone number
	public String getPhone() {
		return this.phone;
	}
}
