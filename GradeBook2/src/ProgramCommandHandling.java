import java.util.List;
import java.util.Scanner;

public class ProgramCommandHandling {

    private String[] gradeOrder = {"A", "A-", "B+", "B", "B-", "C+", "C", "D", "F"};
    private String pidToCompare;
    private String userCommand;
    private Scanner scanner = new Scanner(System.in);
    private GradeBook gradebook = new GradeBook();

    public void inputUserCommand() {
        System.out.println("Please enter a new command:");
        userCommand = scanner.nextLine().trim();

        if (userCommand.startsWith("letter ")) {
            pidToCompare = userCommand.substring(7);
            printLetterGradeByPid(pidToCompare);
        } else if (userCommand.startsWith("name ")) {
            pidToCompare = userCommand.substring(5);
            printNameByPid(pidToCompare);
        } else {
            String[] parts = userCommand.split(" ");
            if (parts.length == 3 && parts[0].equals("change")) {
                pidToCompare = parts[1];
                int newGradeValue = Integer.parseInt(parts[2]);
                changePIDGradeValue(pidToCompare, newGradeValue);
            } else {
                processCommand(userCommand);
            }
        }
    }

    private void processCommand(String command) {
        switch (command) {
            case "min score":
                System.out.println("This is the minimum score of all students:");
                getMinScore();
                break;
            case "min letter":
                System.out.println("This is the minimum letter grade of all students:");
                getMinLetterGrade();
                break;
            case "max letter":
                System.out.println("This is the maximum letter grade of all students:");
                getMaxLetterGrade();
                break;
            case "max score":
                System.out.println("This is the maximum score of all students:");
                getMaxScore();
                break;
            case "average score":
                System.out.println("This is the average score of all students:");
                System.out.println("Average Grade: " + gradebook.calculateAvg());
                break;
            case "average letter":
                System.out.println("This is the average letter grade of all students:");
                gradebook.calculateAndPrintAverageLetterGrade();
                break;
            case "median score":
                System.out.println("This is the median score of all students:");
                System.out.println(gradebook.calculateMedian());
                break;
            case "median letter":
                System.out.println("This is the median score of all students:");
                gradebook.calculateAndPrintMedianLetterGrade();
                break;
            case "tab scores":
                System.out.println("Tab scores:");
                gradebook.printTabScores();
                break;
            case "tab letter":
                gradebook.printTabSeparatedTable();
                break;
            case "quit":
                System.out.println("You have closed the GradeBook.");
                break;
            default:
                System.out.println("Invalid command. Please try again.");
                break;
        }
        inputUserCommand();
    }

    private void getMinScore() {
        List<Student> students = Student.getStudentList();
        int minScore = Integer.MAX_VALUE;
        for (Student student : students) {
            int score = student.getGrade().getScore();
            if (score < minScore) {
                minScore = score;
            }
        }
        System.out.println(minScore);
    }

    private void getMaxScore() {
        List<Student> students = Student.getStudentList();
        int maxScore = Integer.MIN_VALUE;
        for (Student student : students) {
            int score = student.getGrade().getScore();
            if (score > maxScore) {
                maxScore = score;
            }
        }
        System.out.println(maxScore);
    }

    private void getMaxLetterGrade() {
        List<Student> students = Student.getStudentList();
        String maxLetterGrade = "F";
        for (Student student : students) {
            String currentLetterGrade = student.getGrade().getLetterGrade();
            if (isHigherGrade(currentLetterGrade, maxLetterGrade)) {
                maxLetterGrade = currentLetterGrade;
            }
        }
        System.out.println("Maximum letter grade: " + maxLetterGrade);
    }

    private boolean isHigherGrade(String grade1, String grade2) {
        return java.util.Arrays.asList(gradeOrder).indexOf(grade1) < java.util.Arrays.asList(gradeOrder).indexOf(grade2);
    }

    private void getMinLetterGrade() {
        List<Student> students = Student.getStudentList();
        String minLetterGrade = "A";
        for (Student student : students) {
            String currentLetterGrade = student.getGrade().getLetterGrade();
            if (isLowerGrade(currentLetterGrade, minLetterGrade)) {
                minLetterGrade = currentLetterGrade;
            }
        }
        System.out.println("Minimum letter grade: " + minLetterGrade);
    }

    private boolean isLowerGrade(String grade1, String grade2) {
        return java.util.Arrays.asList(gradeOrder).indexOf(grade1) > java.util.Arrays.asList(gradeOrder).indexOf(grade2);
    }

    public void printLetterGradeByPid(String currentPid) {
        List<Student> students = Student.getStudentList();
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
            System.out.println("No student found with PID: " + currentPid);
        }
    }

    public void printNameByPid(String currentPid) {
        List<Student> students = Student.getStudentList();
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
            System.out.println("No student found with PID: " + currentPid);
        }
    }

    public void changePIDGradeValue(String pid, int newGradeValue) {
        List<Student> students = Student.getStudentList();
        boolean studentFound = false;
        for (Student student : students) {
            int storedPid = student.getPid();
            if (storedPid == Integer.parseInt(pid)) {
                student.getGrade().setScore(newGradeValue);
                System.out.println("Grade updated for PID " + pid + " to " + newGradeValue);
                studentFound = true;
                break;
            }
        }
        if (!studentFound) {
            System.out.println("No student found with PID: " + pid);
        }
    }
}
