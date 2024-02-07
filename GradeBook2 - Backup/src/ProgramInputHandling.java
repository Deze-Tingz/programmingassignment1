import java.util.List;
import java.util.Scanner;

public class ProgramInputHandling {
    // Scanner for reading input from the console
    Scanner scnr = new Scanner(System.in);
    // Student object to store current student's information


    // Keyword to exit the data entry loop
    String exitKey = "DONE";
    // Counter to keep track of the number of students entered


    // Method to handle user input for student's information
    public void inputStudentInfo(Scanner scnr) {
        // Flag to keep the data entry loop running
        boolean enteringStudents = true;

        while (enteringStudents) { // Loop to enter student information
            System.out.println("Enter first name:");
            String firstName = scnr.nextLine();
            firstName = formatAndValidateFirstName(firstName);

            System.out.println("Enter last name:");
            String lastName = scnr.nextLine();
            lastName = formatAndValidateLastName(lastName);

            int pid = inputAndValidatePid(scnr);

            int gradeValue = inputAndValidateGrade(scnr);
            scnr.nextLine();  // Consume the newline character left after reading an integer

            Grade newGrade = new Grade(); // Create a new Grade object for each student
            newGrade.setScore(gradeValue);

            Student newStudent = new Student(firstName, lastName, pid, newGrade); // Create a new Student object


            displayStudentInfo(newStudent); // Display the entered student information

            System.out.println("Please enter the information of the next student using the same format.");
            System.out.println("If there are no more students, please enter the keyword “DONE.”");
            System.out.println("Press Enter when you are done.");

            String decision = scnr.nextLine(); // Read the user's decision to continue or end


            // Exit the loop if the user enters "DONE"
            if (decision.equals(exitKey)) {
                enteringStudents = false; // Stop entering students
                System.out.println("Student data entry complete.");
            }

        }

        List<Student> students = Student.getStudentList(); // Access the student list
        System.out.println("List of all students:");
        for (Student student : students) {
            System.out.println("Name: " + student.getFirstName() + " " + student.getLastName() +
                    ", PID: " + student.getPid() + ", Grade: " + student.getGrade().getScore());
        }
    }

    // Formats and validates the first name input
    private String formatAndValidateFirstName(String name) {
        // Remove leading and trailing whitespace   and capitalize the first letter
        name = name.trim().substring(0, 1).toUpperCase() + name.trim().substring(1).toLowerCase();
        // Check for empty input or input with only whitespaces
        while (name.isEmpty() || !name.matches("^[a-zA-Z]+$")) {
            System.out.println("Invalid input for " + "first name" + ". Please enter alphabetical characters without whitespaces.");
            System.out.println("Enter " + "first name" + ":");
            name = scnr.nextLine().trim();
            if (!name.isEmpty()) {
                name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
            }
        }
        return name;
    }

    // Formats and validates the last name input, allowing for an optional period
    private String formatAndValidateLastName(String name) {
        // Remove leading and trailing whitespace and capitalize the first letter
        name = name.trim().substring(0, 1).toUpperCase() + name.trim().substring(1).toLowerCase();
        // Check for empty input or input that does not meet the regex criteria
        while (name.isEmpty() || !name.matches("^[a-zA-Z.]+$")) {
            System.out.println("Invalid input for " + "last name" + ". Please enter alphabetical characters without whitespaces and an optional period.");
            System.out.println("Enter " + "last name" + ":");
            name = scnr.nextLine().trim();
            if (!name.isEmpty()) {
                name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
            }
        }
        return name;
    }


    // Prompts for and validates the PID
    private int inputAndValidatePid(Scanner scnr) {
        System.out.println("Enter PID number:");
        int pid = scnr.nextInt();
        // Convert the PID to a String to check its length and leading digit
        String pidStr = Integer.toString(pid);

        // Validate that the PID is a 7-digit number not starting with zero
        while (pidStr.length() != 7 || pidStr.startsWith("0")) {
            System.out.println("Invalid input. Please enter a 7-digit number that does not start with zero.");
            System.out.println("Enter PID number:");
            pid = scnr.nextInt();
            pidStr = Integer.toString(pid);
        }
        return pid;
    }

    // Prompts for and validates the student's grade
    private int inputAndValidateGrade(Scanner scnr) {
        System.out.println("Enter student grade:");
        int gradeValue = scnr.nextInt();
        // Validate that the grade is between 0 and 100
        while (gradeValue < 0 || gradeValue > 100) {
            System.out.println("Invalid input. Please enter a number between 0 and 100.");
            System.out.println("Enter student grade:");
            gradeValue = scnr.nextInt();
        }
        return gradeValue;
    }

    // Displays the entered student information
    // Update the displayStudentInfo method to take a Student parameter
    public void displayStudentInfo(Student student) {
        System.out.println(student.getFirstName() + " " + student.getLastName() + " " + student.getPid() + " " + student.getGrade().getScore());
        System.out.println();
    }
}


// Summary
/*
* Detailed Summary
*
* The provided code defines a Java class named ProgramInputHandling that is designed to interactively collect and process information for multiple students. Here's a detailed summary of its functionalities:

1. *Initialization*: The class initializes a Scanner object for reading input from the console, a Student object to store the current student's information, and several variables (firstName, lastName, pid, gradeValue) to temporarily hold the individual pieces of student data. It also defines an exitKey string set to "DONE", which is used to signal the end of the data entry process, and a counter to keep track of the number of students entered.

2. *Data Entry Loop*: The inputStudentInfo method contains a loop that allows for the entry of multiple students' information. Within this loop, the user is prompted to enter the first name of a student. If the user enters "DONE", the loop exits, and the program stops asking for more student information.

3. *First Name Handling*: Upon entering a first name (that is not "DONE"), the name is formatted to ensure the first letter is uppercase and the rest are lowercase. The formatted name is validated to ensure it contains only alphabetical characters. If the validation fails, the user is re-prompted to enter a correct first name.

4. *Last Name Handling*: Similar to the first name, the user is prompted to enter a last name, which is then formatted and validated using the same criteria.

5. *PID Handling*: The user is asked to enter a PID number, which must be a 7-digit number not starting with zero. The input is validated, and the user is re-prompted if the input does not meet the criteria.

6. *Grade Handling*: The user enters a grade value for the student, which must be an integer between 0 and 100. The input is validated, and incorrect inputs prompt the user to re-enter a valid grade.

7. *Student Information Storage*: After all the information for a student is successfully entered and validated, it is stored in the Student object. The counter is incremented to reflect the addition of a new student.

8. *Continuation Prompt*: After entering all the data for one student, the user is asked whether they want to continue entering information for another student. If the user types "DONE", the data entry loop exits. If the user presses Enter or provides any other input, the loop continues, and the program prompts for the next student's information.

9. *Display Student Information*: After each student's information is entered, the displayStudentInfo method is called to output the student's first name, last name, PID, and grade to the console.

10. *Modularity*: The code features separate helper methods (formatAndValidateName, inputAndValidatePid, inputAndValidateGrade) to handle specific tasks like formatting and validating names, PIDs, and grades, making the code organized and easier to maintain.

Overall, the code is designed to repeatedly collect detailed and validated information for an unspecified number of students until the user decides to stop the process by entering "DONE".
*
* */