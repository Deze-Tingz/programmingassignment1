import java.util.List;
import java.util.Scanner;

public class ProgramCommandHandling {

    // Array defining the order of letter grades
    private final String[] gradeOrder = {"A", "A-", "B+", "B", "B-", "C+", "C", "D", "F"};
    private final Scanner scanner = new Scanner(System.in); // Scanner for user input
    private final GradeBook gradebook = new GradeBook(); // GradeBook object for managing grades

    // Method to handle user input commands
    public void inputUserCommand() {
        System.out.println("Please enter a new command or type \"quit\" to exit:");
        // Variable to store user input command
        String userCommand = scanner.nextLine().trim(); // Read user input and remove leading/trailing whitespace

        // Check if user command starts with "letter "
        // Variable to store PID for comparison
        String pidToCompare;
        if (userCommand.startsWith("letter ")) {
            pidToCompare = userCommand.substring(7); // Extract PID from user command
            printLetterGradeByPid(pidToCompare); // Print letter grade for the given PID
            inputUserCommand();
        }
        // Check if user command starts with "name "
        else if (userCommand.startsWith("name ")) {
            pidToCompare = userCommand.substring(5); // Extract PID from user command
            printNameByPid(pidToCompare); // Print name for the given PID
            inputUserCommand();
        }
        // If the user command is not specific to PID or name
        else {
            String[] parts = userCommand.split(" "); // Split the command into parts
            // Check if the command is in the format "change <PID> <newGradeValue>"
            if (parts.length == 3 && parts[0].equals("change")) {
                pidToCompare = parts[1]; // Extract PID from the command
                int newGradeValue = Integer.parseInt(parts[2]); // Extract new grade value
                changePIDGradeValue(pidToCompare, newGradeValue); // Change grade value for the given PID
            }
            // If the command is not "change", process it based on predefined commands
            else {
                processCommand(userCommand); // Process the command
            }
            inputUserCommand();
        }
    }

    // Method to process predefined commands
    private void processCommand(String command) {
        switch (command) {
            case "min score":
                System.out.println("This is the minimum score of all students:");
                getMinScore(); // Print minimum score of all students
                break;
            case "min letter":
                System.out.println("This is the minimum letter grade of all students:");
                getMinLetterGrade(); // Print minimum letter grade of all students
                break;
            case "max letter":
                System.out.println("This is the maximum letter grade of all students:");
                getMaxLetterGrade(); // Print maximum letter grade of all students
                break;
            case "max score":
                System.out.println("This is the maximum score of all students:");
                getMaxScore(); // Print maximum score of all students
                break;
            case "average score":
                System.out.println("This is the average score of all students:");
                System.out.println("Average Grade: " + gradebook.calculateAvg()); // Print average score
                break;
            case "average letter":
                System.out.println("This is the average letter grade of all students:");
                gradebook.calculateAndPrintAverageLetterGrade(); // Print average letter grade
                break;
            case "median score":
                System.out.println("This is the median score of all students:");
                System.out.println(gradebook.calculateMedian()); // Print median score
                break;
            case "median letter":
                System.out.println("This is the median score of all students:");
                gradebook.calculateAndPrintMedianLetterGrade(); // Print median letter grade
                break;
            case "tab scores":
                System.out.println("tab scores:");
                gradebook.printTabScores(); // Print tab-separated scores
                break;
            case "tab letters":
                gradebook.printTabLetters(); // Print tab-separated letter grades
                break;
            case "quit":
                System.out.println("You have closed the GradeBook.");
                break;
            default:
                System.out.println("Invalid command. Please try again.");
                inputUserCommand();
        }
        // If the keyword "quit" is not entered close the Grade Book
        if(command.equals("quit")) {
            System.exit(0);
        } else {
            inputUserCommand();
        }
    }

    // Method to find and print the minimum score of all students
    private void getMinScore() {
        List<Student> students = Student.getStudentList(); // Get list of students
        int minScore = Integer.MAX_VALUE; // Initialize minScore with maximum integer value
        for (Student student : students) {
            int score = student.getGrade().getScore();
            if (score < minScore) {
                minScore = score; // Update minScore if a lower score is found
            }
        }
        System.out.println(minScore); // Print the minimum score
    }

    // Method to find and print the maximum score of all students
    private void getMaxScore() {
        List<Student> students = Student.getStudentList(); // Get list of students
        int maxScore = Integer.MIN_VALUE; // Initialize maxScore with minimum integer value
        for (Student student : students) {
            int score = student.getGrade().getScore();
            if (score > maxScore) {
                maxScore = score; // Update maxScore if a higher score is found
            }
        }
        System.out.println(maxScore); // Print the maximum score
    }

    // Method to find and print the maximum letter grade of all students
    private void getMaxLetterGrade() {
        List<Student> students = Student.getStudentList(); // Get list of students
        String maxLetterGrade = "F"; // Start with lowest grade
        for (Student student : students) {
            String currentLetterGrade = student.getGrade().getLetterGrade();
            if (isHigherGrade(currentLetterGrade, maxLetterGrade)) {
                maxLetterGrade = currentLetterGrade; // Update maxLetterGrade if a higher grade is found
            }
        }
        System.out.println("Maximum letter grade: " + maxLetterGrade); // Print the maximum letter grade
    }

    // Helper method to determine if one letter grade is higher than another
    private boolean isHigherGrade(String grade1, String grade2) {
        return java.util.Arrays.asList(gradeOrder).indexOf(grade1) < java.util.Arrays.asList(gradeOrder).indexOf(grade2);
    }

    // Method to find and print the minimum letter grade of all students
    private void getMinLetterGrade() {
        List<Student> students = Student.getStudentList(); // Get list of students
        String minLetterGrade = "A"; // Start with highest grade
        for (Student student : students) {
            String currentLetterGrade = student.getGrade().getLetterGrade();
            if (isLowerGrade(currentLetterGrade, minLetterGrade)) {
                minLetterGrade = currentLetterGrade; // Update minLetterGrade if a lower grade is found
            }
        }
        System.out.println("Minimum letter grade: " + minLetterGrade); // Print the minimum letter grade
    }

    // Helper method to determine if one letter grade is lower than another
    private boolean isLowerGrade(String grade1, String grade2) {
        return java.util.Arrays.asList(gradeOrder).indexOf(grade1) > java.util.Arrays.asList(gradeOrder).indexOf(grade2);
    }

    // Method to print the letter grade for a given PID
    public void printLetterGradeByPid(String currentPid) {
        List<Student> students = Student.getStudentList(); // Get list of students
        boolean studentFound = false;
        for (Student student : students) {
            int storedPid = student.getPid();
            if (storedPid == Integer.parseInt(currentPid)) {
                System.out.println("Letter Grade for PID " + currentPid + ": " + student.getGrade().getLetterGrade());
                studentFound = true;
                break;
            }
        }
        if (!studentFound) {
            System.out.println("No student found with PID: " + currentPid); // Print message if student not found
        }
    }

    // The Method to print the name for a given PID
    public void printNameByPid(String currentPid) {
        List<Student> students = Student.getStudentList(); // Get list of students
        boolean studentFound = false;
        for (Student student : students) {
            int storedPid = student.getPid();
            if (storedPid == Integer.parseInt(currentPid)) {
                System.out.println("Full Name for PID " + currentPid + ": " + student.getFirstName() + " " + student.getLastName());
                studentFound = true;
                break;
            }
        }
        if (!studentFound) {
            System.out.println("No student found with PID: " + currentPid); // Print message if student not found
        }
    }

    // Method to change the grade value for a given PID
    public void changePIDGradeValue(String pid, int newGradeValue) {
        List<Student> students = Student.getStudentList(); // Get list of students
        boolean studentFound = false;
        for (Student student : students) {
            int storedPid = student.getPid();
            if (storedPid == Integer.parseInt(pid)) {
                student.getGrade().setScore(newGradeValue); // Update grade value
                System.out.println("Grade updated for PID " + pid + " to " + newGradeValue); // Print confirmation message
                studentFound = true;
                break;
            }
        }
        if (!studentFound) {
            System.out.println("No student found with PID: " + pid); // Print message if student not found
        }
    }
}
