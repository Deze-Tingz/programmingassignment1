/*Author: Val I. John
Course: 8.2 LAB (LM): Driving cost - Methods
Date: October 23th 2023
Assignment: Driving cost - Methods
Instructor: Sergio Pisano
Description: A method drivingCost() with input parameters milesPerGallon, dollarsPerGallon, 
			and milesDriven that returns the dollar cost to drive those miles.
 */

//package drivingCosts;

import java.util.Scanner;

//Importing the Scanner class to read input from the user
import java.util.Scanner;

public class LabProgram {

 // Main method where the program execution starts
 public static void main(String[] args) {
     // Creating a Scanner object to take user input
     Scanner scanner = new Scanner(System.in);

     // Reading the miles per gallon value from the user
     double milesPerGallon = scanner.nextDouble();
     
     // Reading the dollars per gallon value from the user
     double dollarsPerGallon = scanner.nextDouble();

     // Calculating and displaying the driving cost for 10 miles
     System.out.printf("%.2f ", drivingCost(milesPerGallon, dollarsPerGallon, 10.0));
     
     // Calculating and displaying the driving cost for 50 miles
     System.out.printf("%.2f ", drivingCost(milesPerGallon, dollarsPerGallon, 50.0));
     
     // Calculating and displaying the driving cost for 400 miles
     System.out.printf("%.2f%n", drivingCost(milesPerGallon, dollarsPerGallon, 400.0));
 }

 // Method to calculate the driving cost based on miles per gallon, dollars per gallon, and miles driven
 public static double drivingCost(double milesPerGallon, double dollarsPerGallon, double milesDriven) {
     // Returning the computed cost of driving
     return (milesDriven / milesPerGallon) * dollarsPerGallon;
 }
}

/** CODE OUTPUT
 * 
20.0
3.1599
1.58 7.90 63.20
 * 
 * 
 */

