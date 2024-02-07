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

package module4_discussion_5_oop_group_3;

//Define the ServiceQuote class to calculate the service charges for a car
public class ServiceQuote {

	// Declare private variables for parts charges, labor charges, and car age discount
	private double partsCharges;
	private double laborCharges;
	private double carAgeDiscount;

	// Method to set the parts charges
	public void setPartsCharges(double p) {
		this.partsCharges = p;
	}

	// Method to set the labor charges
	public void setLaborCharges(double l) {
		this.laborCharges = l;
	}

	// Method to calculate and return the sales tax based on the total of parts and labor charges
	public double salesTax() {
		return (0.07 * (this.partsCharges + this.laborCharges));
	}

	// Method to set the car age discount based on the car's model year
	public void setCarAgeDiscount(int carYear) {
		if (carYear < 2005) {
			this.carAgeDiscount = 0.1; // Apply a 10% discount for cars older than 2005
		} else {
			this.carAgeDiscount = 0; // No discount for cars from 2005 and later
		}
	}

	// Method to get the current car age discount value
	public double getCarAgeDiscount() {
		return this.carAgeDiscount;
	}

	// Method to calculate and return the total service charges after applying the car age discount
	public double totalCharges() {
		// Calculate the subtotal by adding sales tax, parts charges, and labor charges
		double subtotal = this.salesTax() + this.partsCharges + this.laborCharges;
		// Calculate the total charges after applying the car age discount
		double total = (subtotal - (subtotal * this.carAgeDiscount));
		return total;
	}
}


/** 
 CODE OUTPUT
 
Enter customer's name: Val
Enter car’s model year: 2005
Enter estimated labor cost: 200
Enter estimated parts charge: 50
Dear Val, your total quote is: 267.50
Total taxes: 17.50
Total discount:0.0%
 * 
 * */


/** 
 * Observations made:
 * 
 * Cannot enter a "space" in between the customers first 
 * and last name can only enter one word to continue
 * */
 