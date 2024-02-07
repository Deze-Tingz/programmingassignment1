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

public class Car {
    // Private fields to hold the car's model year, purchase price, and current value
    private int modelYear; 
    private int purchasePrice;
    private int currentValue;

    // Setter method to set the car's model year
    public void setModelYear(int userYear) {
        modelYear = userYear;
    }

    // Getter method to retrieve the car's model year
    public int getModelYear() {
        return modelYear;
    }

    // Setter method to set the car's purchase price
    public void setPurchasePrice(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    // Getter method to retrieve the car's purchase price
    public int getPurchasePrice() {
        return purchasePrice;
    }

    // Method to calculate the current value of the car based on its age and depreciation rate
    public void calcCurrentValue(int currentYear) {
        // Depreciation rate for the car's value each year
        double depreciationRate = 0.15;
        
        // Calculate the age of the car
        int carAge = currentYear - modelYear;

        // Car depreciation formula to calculate its current value
        this.currentValue = (int) 
                Math.round(purchasePrice * Math.pow((1 - depreciationRate), carAge));
    }

    // Method to print the car's model year, purchase price, and current value
    public void printInfo() {
        System.out.println("Car's information:");
        System.out.println("  Model year: " + modelYear); 
        System.out.println("  Purchase price: $" + purchasePrice);
        System.out.println("  Current value: $" + currentValue);
    }
}

/** 
 * CODE OUTPUT
 * 
 * 
 * */
