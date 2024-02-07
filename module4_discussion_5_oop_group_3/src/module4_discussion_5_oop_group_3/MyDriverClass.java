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


// Import required packages
package module4_discussion_5_oop_group_3;

import java.util.Scanner; // Import Scanner class for reading user input

public class MyDriverClass {

	public static void main(String[] args) {

		// Create a new Scanner object for reading user input
		Scanner in = new Scanner(System.in);

		// Prompt user for customer's name and read input
		System.out.print("Enter customer's name: ");
		String myName = in.next();

		// Prompt user for car's model year and read input
		System.out.print("Enter car’s model year: ");
		int myCarYear= in.nextInt();

		// Prompt user for estimated labor cost and read input
		System.out.print("Enter estimated labor cost: ");
		double myLabor = in.nextDouble();

		// Prompt user for estimated parts charge and read input
		System.out.print("Enter estimated parts charge: ");
		double myParts = in.nextDouble();

		// Create new instances of Customer, Car, and ServiceQuote classes
		Customer myCustomer = new Customer (); 
		Car myCar = new Car();
		ServiceQuote myQuote = new ServiceQuote();

		// Set customer's name using the setName method
		myCustomer.setName(myName);
		// Set car's model year using the setYear method
		myCar.setYear(myCarYear);
		// Calculate and set the car age discount based on the car's model year
		myQuote.setCarAgeDiscount(myCar.getYear());
		// Set labor charges using the setLaborCharges method
		myQuote.setLaborCharges(myLabor);
		// Set parts charges using the setPartsCharges method
		myQuote.setPartsCharges(myParts);

		// Display the total quote amount to the customer using printf
		System.out.printf("Dear " + myCustomer.getName() + ", your total quote is: %.2f", 
				myQuote.totalCharges());

		// Display the total sales tax amount to the customer using printf
		System.out.printf("\nTotal taxes: %.2f", myQuote.salesTax());
		// Display the total car age discount percentage to the customer
		System.out.print("\nTotal discount:" + (myQuote.getCarAgeDiscount()*100) + "%");

		// Closes scanner
		in.close();
	}
}
