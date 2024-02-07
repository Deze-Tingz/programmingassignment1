//package nutritionalInfo;

/*Author: Val I. John
Course: 8.1 LAB (LM): Nutritional Information (classes/constructors)
Date: October 23th 2023
Assignment: Nutritional Information (classes/constructors)
Instructor: Sergio Pisano
Description: Complete the FoodItem class (in file FoodItem.java) 
             with constructors to initialize each food item
 */


import java.util.Scanner;

public class NutritionalInfo {
	public static void main(String[] args) {

		// Create a scanner object to read user input
		Scanner scnr = new Scanner(System.in);

		// Declare a FoodItem object
		FoodItem foodItem;

		// Read the name of the food item from user input
		String itemName = scnr.next();

		// Check if the entered item is "Water" (case-insensitive)
		if(itemName.equalsIgnoreCase("Water")) {

			// Create a default FoodItem object (assuming default is for Water)
			foodItem = new FoodItem();

			// Print the nutritional information for the default food item (Water)
			foodItem.printInfo();

			// Display the number of calories for 1 serving of the food item
			System.out.printf("Number of calories for %.2f serving(s): %.2f\n", 1.0, 
					foodItem.getCalories(1.0));
		}
		else {

			// Read the nutritional information for the food item from user input
			double amountFat = scnr.nextDouble();
			double amountCarbs = scnr.nextDouble();
			double amountProtein = scnr.nextDouble();

			// Create a FoodItem object with the provided nutritional information
			foodItem = new FoodItem(itemName, amountFat, amountCarbs, amountProtein);

			// Read the number of servings from user input
			double numServings = scnr.nextDouble();

			// Print the nutritional information for the food item
			foodItem.printInfo();

			// Display the number of calories for 1 serving of the food item
			System.out.printf("Number of calories for %.2f serving(s): %.2f\n", 1.0,
					foodItem.getCalories(1.0));

			// Display the number of calories for the entered number of servings
			System.out.printf("Number of calories for %.2f serving(s): %.2f\n", numServings,
					foodItem.getCalories(numServings));
		}
	}
}


/** CODE OUTPUT 1
Water
Nutritional information per serving of Water:
Fat: 0.00 g
Carbohydrates: 0.00 g
Protein: 0.00 g
Number of calories for 1.00 serving(s): 0.00
 */

/** CODE OUTPUT 2 
M&M's
10.0
34.0
2.0
3.0
Nutritional information per serving of M&M's:
Fat: 10.00 g
Carbohydrates: 34.00 g
Protein: 2.00 g
Number of calories for 1.00 serving(s): 234.00
Number of calories for 3.00 serving(s): 702.00

*/
