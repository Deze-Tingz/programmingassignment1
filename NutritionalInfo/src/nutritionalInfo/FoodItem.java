//package nutritionalInfo;

/*Author: Val I. John
Course: 8.1 LAB (LM): Nutritional Information (classes/constructors)
Date: October 23th 2023
Assignment: Nutritional Information (classes/constructors)
Instructor: Sergio Pisano
Description: Complete the FoodItem class (in file FoodItem.java) 
             with constructors to initialize each food item
 */



public class FoodItem {

	// Private fields to hold the nutritional information of a food item
	private String name;
	private double fat;
	private double carbs;
	private double protein;

	// Default constructor: Initializes a food item with default values
	public FoodItem() {
		name = "Water";    // Default name is set to "Water"
		fat = 0.0;         // Default fat content is set to 0.0
		carbs = 0.0;       // Default carbohydrate content is set to 0.0
		protein = 0.0;     // Default protein content is set to 0.0
	}

	// Initializes a food item with provided values
	public FoodItem(String foodName, double gramsOfFat, double gramsOfCarbs, double gramsOfProtein) {
		name = foodName;
		fat = gramsOfFat;
		carbs = gramsOfCarbs;
		protein = gramsOfProtein;
	}

	// Getter method for the name of the food item
	public String getName() {
		return name;
	}

	// Getter method for the fat content of the food item
	public double getFat() {
		return fat;
	}

	// Getter method for the carbohydrate content of the food item
	public double getCarbs() {
		return carbs;
	}

	// Getter method for the protein content of the food item
	public double getProtein() {
		return protein;
	}

	// Method to calculate the total calories based on servings and nutritional content
	public double getCalories(double numServings) {
		// Calorie calculation formula: Calories from fat + Calories from carbs + Calories from protein, multiplied by number of servings
		double calories = ((fat * 9) + (carbs * 4) + (protein * 4)) * numServings;
		return calories;
	}

	// Method to print the nutritional information of the food item
	public void printInfo() {
		System.out.println("Nutritional information per serving of " + name + ":");
		System.out.printf("  Fat: %.2f g\n", fat);
		System.out.printf("  Carbohydrates: %.2f g\n", carbs);
		System.out.printf("  Protein: %.2f g\n", protein);
	}
}

