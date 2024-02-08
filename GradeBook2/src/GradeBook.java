import java.util.Arrays;
import java.util.List;

public class GradeBook {

    // Method to calculate the average score of all students
    public double calculateAvg() {
        List<Student> students = Student.getStudentList();
        double sum = 0;
        for (Student s : students)
            sum += s.getGrade().getScore();
        return sum / students.size();
    }

    // Method to calculate the median score of all students
    public float calculateMedian() {
        List<Student> students = Student.getStudentList();
        int i = 0, n = students.size();
        int[] scores = new int[n];
        for (Student s : students)
            scores[i++] = s.getGrade().getScore();
        Arrays.sort(scores);
        if (n % 2 == 0)
            return (scores[n / 2] + scores[n / 2 - 1]) / 2.0f;
        else
            return scores[n / 2];
    }

    // Method to print the list of all students with their scores in a tab-separated format
    public void printTabScores() {
        List<Student> students = Student.getStudentList();
        // Print the header with fixed width for each column
        System.out.printf("%-15s %-15s %-10s %-12s\n", "First Name", "Last Name", "PID", "Grade");

        // Print each student's information with the same fixed width to ensure alignment
        for (Student student : students) {
            String firstName = student.getFirstName();
            String lastName = student.getLastName();
            String pid = Integer.toString(student.getPid());
            String gradeValue = String.valueOf(student.getGrade().getScore());

            // Adjust the %-15, %-15, %-10, %-12 to fit your needs
            System.out.printf("%-15s %-15s %-10s %-12s\n", firstName, lastName, pid, gradeValue);
        }
    }

    // Array defining the order of letter grades
    private final String[] gradeOrder = {"A", "A-", "B+", "B", "B-", "C+", "C", "D", "F"};

    // Method to calculate and print the average letter grade of all students
    public void calculateAndPrintAverageLetterGrade() {
        List<Student> students = Student.getStudentList();
        int totalScore = 0;
        for (Student student : students) {
            totalScore += student.getGrade().getScore();
        }
        double averageScore = (double) totalScore / students.size();
        String averageLetterGrade = determineLetterGrade(averageScore);
        System.out.println("Average letter grade: " + averageLetterGrade);
    }

    // Method to determine the letter grade based on the average score
    private String determineLetterGrade(double averageScore) {
        for (int i = 0; i < gradeOrder.length; i++) {
            if (averageScore >= getLowerBound(i)) {
                return gradeOrder[i];
            }
        }
        return "F";
    }

    // Helper method to get the lower bound score for a letter grade index
    private int getLowerBound(int gradeIndex) {
        if (gradeIndex == 0) {
            return 0;
        } else {
            return (int) Math.ceil(getUpperBound(gradeIndex - 1));
        }
    }

    // Helper method to get the upper bound score for a letter grade index
    private double getUpperBound(int gradeIndex) {
        if (gradeIndex == gradeOrder.length - 1) {
            return Double.POSITIVE_INFINITY;
        } else {
            return (gradeIndex == 0) ? 100 : (gradeIndex * 10) - 0.1;
        }
    }

    // Method to calculate and print the median letter grade of all students
    public void calculateAndPrintMedianLetterGrade() {
        List<Student> students = Student.getStudentList();
        int[] scores = new int[students.size()];
        for (int i = 0; i < students.size(); i++) {
            scores[i] = students.get(i).getGrade().getScore();
        }
        Arrays.sort(scores);
        double medianScore;
        int middleIndex = scores.length / 2;
        if (scores.length % 2 == 0) {
            medianScore = (double) (scores[middleIndex - 1] + scores[middleIndex]) / 2;
        } else {
            medianScore = scores[middleIndex];
        }
        String medianLetterGrade = determineLetterGrade(medianScore);
        System.out.println("Median letter grade: " + medianLetterGrade);
    }

    // Method to print the list of all students with their names, IDs, and letter grades in a tab-separated format
    public void printTabLetters() {
        List<Student> students = Student.getStudentList();
        // Print the header with fixed width for each column
        System.out.printf("%-15s %-15s %-10s %-12s\n", "First Name", "Last Name", "PID", "Letter Grade");

        // Print each student's information with the same fixed width to ensure alignment
        for (Student student : students) {
            String firstName = student.getFirstName();
            String lastName = student.getLastName();
            String pid = Integer.toString(student.getPid());
            String letterGrade = student.getGrade().getLetterGrade();

            // Adjust the %-15, %-15, %-10, %-12 to fit your needs
            System.out.printf("%-15s %-15s %-10s %-12s\n", firstName, lastName, pid, letterGrade);
        }
    }
}
