/*Author: Val I. John
Course: 8.3 LAB (LM): Car value (classes)
Date: October 24th 2023
Assignment: Car Value (Classes)
Instructor: Sergio Pisano
Description: Complete the Car class (in file Car.java) with methods to set and get 
			the purchase price of a car (setPurchasePrice(),getPurchasePrice()),
			and to output the car's information (printInfo()).
 */

//package carValue;

import java.util.Scanner;



//Importing the Scanner class to read input from the user
import java.util.Scanner;

public class CarValue {

 // Main method where the program execution starts
 public static void main(String[] args) {
     // Creating a Scanner object to take user input
     Scanner scnr = new Scanner(System.in);

     // Creating a new Car object
     Car myCar = new Car();

     // Reading the model year of the car from the user
     int userYear = scnr.nextInt();
     
     // Reading the purchase price of the car from the user
     int userPrice = scnr.nextInt();
     
     // Reading the current year from the user
     int userCurrentYear = scnr.nextInt();

     // Setting the model year of the car using the setter method
     myCar.setModelYear(userYear);
     
     // Setting the purchase price of the car using the setter method
     myCar.setPurchasePrice(userPrice);
     
     // Calculating the current value of the car based on the user's input
     myCar.calcCurrentValue(userCurrentYear);

     // Printing the information about the car
     myCar.printInfo();
 }
}


/** 
 * CODE OUTPUT 
 * 
2011
18000
2018
Car's information:
Model year: 2011
Purchase price: 18000
Current value: 5770
 * 
 * */
