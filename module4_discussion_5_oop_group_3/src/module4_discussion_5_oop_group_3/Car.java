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

// Define the Car class to store and manage car details
public class Car {

	// Declare private variables for car's make, model, and year
	private String make;
	private String model;
	private int year;

	// Method to set the car's make
	public void setMake(String n) {
		this.make = n;
	}

	// Method to set the car's model
	public void setModel(String m) {
		this.model = m;
	}

	// Method to set the car's manufacturing year
	public void setYear(int y) {
		this.year = y;
	}

	// Method to get the car's make
	public String getMake() {
		return this.make;
	}

	// Method to get the car's model
	public String getModel() {
		return this.model;
	}

	// Method to get the car's manufacturing year
	public int getYear() {
		return this.year;
	}
}
