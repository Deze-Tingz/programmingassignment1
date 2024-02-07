
import java.util.Scanner;

/*
Author: Val I. John
Course: COP 3337 Java Programming II
Date: January 29th, 2024
Assignment: Programming Assignment 1 (GradeBook)
Instructor: Kiavash Bahreni

Description: Contains the main method which does the followings: first it gets
user’s input data from System.in verifies the data to make sure there is no problem
with the input data. Then, it asks for user’s commands and gets them via System.in.
Finally, it processes each command, and outputs the results to System.out.
 */

public class Main {

    public static void main(String[] args) {
        // Create a scanner object to read input from the console
        Scanner scnr = new Scanner(System.in);

        // Create an instance of ProgramInputHandling to handle user input
        ProgramInputHandling userInput = new ProgramInputHandling();
        ProgramCommandHandling userCommands = new ProgramCommandHandling();

        System.out.println("Welcome to my grade book!");
        System.out.println();

        System.out.println("Please enter the information of the first student using the following format:");
        System.out.println();

        System.out.println("\"firstName lastName PID grade\"");
        System.out.println();

        System.out.println("Press Enter when you are done.");
        System.out.println();

        // Handles user input for students and displays information
        userInput.inputStudentInfo(scnr);

        // Handles user commands
        userCommands.inputUserCommand();






    }
}
