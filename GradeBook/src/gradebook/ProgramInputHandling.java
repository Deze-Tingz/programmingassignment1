package gradebook;

import java.util.Scanner;

public class ProgramInputHandling {
    Scanner scnr = new Scanner(System.in);
    Student student = new Student();
    private String firstName;
    private String lastName;
    private String pid;
    private int gradeValue;
    

    // Method to handle user input for student's information
    public void inputStudentInfo(Scanner scnr) {
        
    	// Input user's first name and checks for formatting 
    	
    	    do {
    	        
    	        System.out.println("Enter first name:");
    	        this.firstName = scnr.next();
    	        // Convert the first letter to uppercase and the rest to lowercase
    	        this.firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
    	        if (firstName.matches("^[a-zA-Z]+$") && !firstName.contains(" ")) {
    	            student.setFirstName(firstName);
    	        } else {
    	            System.out.println("Invalid input. Please enter alphabetical characters without whitespaces.");
    	        }
    	    } while (!this.firstName.matches("^[a-zA-Z]+$") || this.firstName.contains(" "));
    	

       
        // Input user's last name and checks for formatting 
        do {
            System.out.println("Enter last name:");
            this.lastName = scnr.next();
            // Convert the first letter to uppercase and the rest to lowercase
            this.lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
            if (lastName.matches("^[a-zA-Z]+$") && !lastName.contains(" ")) {
                student.setLastName(lastName);
            }
            if (this.lastName.matches("^[a-zA-Z.]+$") && !this.lastName.contains(" ")) {
                student.setLastName(this.lastName);
            } else {
                System.out.println("Invalid input. Please enter alphabetical characters without whitespaces.");
            }
        } while (!this.lastName.matches("^[a-zA-Z.]+$") || this.lastName.contains(" "));

        // Input user's PID
        do {
            System.out.println("Enter PID number:");
            this.pid = scnr.next();
            if (this.pid.matches("^[1-9]\\d{6}$") && !this.pid.contains(" ")) {
                student.setPid(this.pid);
            } else {
                System.out.println(
                        "Invalid input. Please enter 7 numerical digits without whitespaces. Cannot start with zeroes.");
            }
        } while (!this.pid.matches("^[1-9]\\d{6}$") || this.pid.contains(" "));

        // Input user's grade
        do {
            System.out.println("Enter student grade:");
            this.gradeValue = scnr.nextInt();
            if ((this.gradeValue >= 0) && (this.gradeValue <= 100)) {
                // FIX ME: Set the grade here
            }
            // Check for invalid grade input
            if ((this.gradeValue < 0) || (this.gradeValue > 100)) {
                System.out.println("Invalid input. Please enter a number between 0 and 100.");
            }
        } while ((this.gradeValue < 0) || (this.gradeValue > 100));

        
    }
    

    // Method to display student information
    public void displayStudentInfo() {
        // Display the entered student information
        System.out.print(
                student.getFirstName() + " " + student.getLastName() + " " + "" + student.getPid() + " " + this.gradeValue);
        System.out.println();
        System.out.println();
     
    }
//    public void inputStudentInfoWhileLoop () {
//    	
//    	
//    	
//    	while(firstName.equals("DONE")) {
//    		
//    		System.out.println("Please enter the information of the next student using the same format.");
//            System.out.println("If there is no more students, please enter the keyword “DONE”");
//            System.out.println("Press Enter when you are done.");
//            System.out.println();
//            
//            
//            
//    		
//    	}
//    }
}
