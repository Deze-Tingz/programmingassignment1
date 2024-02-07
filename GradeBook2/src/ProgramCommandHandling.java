import java.util.List;
import java.util.Scanner;

public class ProgramCommandHandling {

    String[] gradeOrder = new String[]{"A", "A-", "B+", "B", "B-", "C+", "C", "D", "F"};
    private String pidToCompare;

    private String userCommand;
    Scanner scnr = new Scanner(System.in);


    public void inputUserCommand() {

        System.out.println("Please enter a new command:");
        userCommand = scnr.nextLine().trim();

        if (userCommand.startsWith("letter ")) {
            this.pidToCompare = userCommand.substring(7); // Assuming PID follows after "letter "
            printLetterGradeByPid(pidToCompare);
        } else if (userCommand.startsWith("name ")) {
            this.pidToCompare = userCommand.substring(5); // Assuming PID follows after "name "
            printNameByPid(this.pidToCompare);
            switch (userCommand) {
                case "min score":
                    System.out.println("This is the minimum score of all students");
                    System.out.println();

                    // Prints the lowest score of all students
                    getMinScore();
                    // Asks the user for more input
                    inputMessage();
                    break;
                case "min letter":
                    System.out.println("This is the minimum letter grade of all students");
                    System.out.println();

                    // Prints the minimum letter grade of all students
                    getMinLetterGrade();
                    // Asks the user for more input
                    inputMessage();

                    break;
                case "max letter":
                    System.out.println("This is the maximum letter grade of all students");
                    System.out.println();

                    // Prints the max letter grade of all students
                    getMaxLetterGrade();
                    // Asks the user for more input
                    inputMessage();
                    break;
                case "max score":
                    System.out.println("This is the maximum score of all students");
                    System.out.println();

                    // Prints the maximum score of all students
                    getMaxScore();
                    // Asks the user for more input
                    inputMessage();
                    break;

                case "name PID":
                    System.out.println("Name PID");
                    break;
                case "change PID to new grade":
                    System.out.println("Change PID to new grade");
                    break;
                case "average score":
                    System.out.println("Avg score");
                    break;
                case "average letter":
                    System.out.println("Avg letter");
                    break;
                case "median score":
                    System.out.println("Median score");
                    break;
                case "median letter":
                    System.out.println("Median letter");
                    break;
                case "tab scores":
                    System.out.println("Tab scores");
                    break;
                case "tab letter":
                    System.out.println("Tab letter");
                    break;
                case "quit":
                    System.out.println("You have closed the GradeBook.");
                    break;
                default:
                    inputMessage();

            }
        }
    }

    public void inputMessage() {

        if (this.userCommand.contentEquals(this.userCommand)) {
            System.out.println("Please enter another command otherwise type \"quit\" to exit.");
            inputUserCommand();
        }
    }

    private void getMinScore() {
        // Note: in order for this to work the user has to enter more than one entry with a grade lower than the first otherwise change < to <=
        List<Student> students = Student.getStudentList(); // Access the student list
        int minScore = students.getFirst().getGrade().getScore();
        for (Student student : students) {
            // If the current student's score is less than or equal the minScore, update minScore
            if (student.getGrade().getScore() <= minScore) {
                minScore = student.getGrade().getScore();
                System.out.println(minScore);
                System.out.println();
            }
        }
    }


    private void getMaxScore() {
        List<Student> students = Student.getStudentList(); // Access the student list
        int minScore = students.getFirst().getGrade().getScore();
        for (Student student : students) {
            // If the current student's score is more than or equal the maxScore, update maxScore
            if (student.getGrade().getScore() >= minScore) {
                int maxScore = student.getGrade().getScore();
                System.out.println(maxScore);
                System.out.println();
            }
        }
    }

    private void getMaxLetterGrade() {
        List<Student> students = Student.getStudentList(); // Access the student list
        String maxLetterGrade = "F"; // Start with the lowest possible grade

        for (Student student : students) {
            String currentLetterGrade = student.getGrade().getLetterGrade();
            if (isHigherGrade(currentLetterGrade, maxLetterGrade)) {
                maxLetterGrade = currentLetterGrade;
            }
        }

        System.out.println("Maximum letter grade: " + maxLetterGrade);
        System.out.println();
    }

    // Helper method to determine if one letter grade is higher than another
    private boolean isHigherGrade(String grade1, String grade2) {
        // Define the order of grades from highest to lowest

        // Find the indices of the grades in the gradeOrder array
        int index1 = java.util.Arrays.asList(gradeOrder).indexOf(grade1);
        int index2 = java.util.Arrays.asList(gradeOrder).indexOf(grade2);

        // If grade1 comes before grade2 in the order, it is a higher grade
        return index1 < index2;
    }

    private void getMinLetterGrade() {
        List<Student> students = Student.getStudentList();
        String minLetterGrade = "A"; // Start with the highest possible grade

        for (Student student : students) {
            String currentLetterGrade = student.getGrade().getLetterGrade();
            if (isLowerGrade(currentLetterGrade, minLetterGrade)) {
                minLetterGrade = currentLetterGrade;
            }
        }

        System.out.println("Minimum letter grade: " + minLetterGrade);
        System.out.println();
    }

    // Helper method to determine if one letter grade is lower than another
    private boolean isLowerGrade(String grade1, String grade2) {
        // Define the order of grades from highest to lowest

        // Find the indices of the grades in the gradeOrder array
        int index1 = java.util.Arrays.asList(gradeOrder).indexOf(grade1);
        int index2 = java.util.Arrays.asList(gradeOrder).indexOf(grade2);

        // If grade1 comes after grade2 in the order, it is a lower grade
        return index1 > index2;
    }

    // Method to find and print the letter-grade of the student with the given PID

    public void printLetterGradeByPid(String currentPid) {
        List<Student> students = Student.getStudentList();
        boolean studentFound = false; // Flag to track if a student is found

        for (Student student : students) {
            int storedPid = student.getPid();
            if (storedPid == Integer.parseInt(this.pidToCompare)) {
                System.out.println("Letter Grade for PID " + this.pidToCompare + ": " + student.getGrade().getLetterGrade());
                studentFound = true; // Set the flag to true since a student was found
            }
        }

        if (!studentFound) { // Check the flag before printing the message
            System.out.println("No student found with PID: " + currentPid);
        }
    }



    // Method to find and print the full name of the student with the given PID
    public void printNameByPid(String currentPid) {
        List<Student> students = Student.getStudentList();
        for (Student student : students) {
            if (String.valueOf(student.getPid()).equals(currentPid)) {
                System.out.println("Full Name for PID " + currentPid + ": " + student.getFirstName() + " " + student.getLastName());
                return;
            }
        }
        System.out.println("No student found with PID: " + currentPid);
    }
}






