

/*
 Description: Keeps a list of students info in the following data structure:
java.util.ArrayList{Student}.

*/


import java.util.Arrays;
import java.util.List;

public class GradeBook {


    public double calculateAvg() {
        List<Student> students = Student.getStudentList();
        double sum = 0;
        for (Student s : students)
            sum += s.getGrade().getScore();
        return sum / students.size();
    }

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

    public void printTabScores() {
        List<Student> students = Student.getStudentList();
        for (Student student : students)
            System.out.printf("%s\t%s\t%d\t%d\n", student.getFirstName(), student.getLastName(), student.getPid(), student.getGrade().getScore());
    }

    private final String[] gradeOrder = new String[]{"A", "A-", "B+", "B", "B-", "C+", "C", "D", "F"};

    // Method to calculate and print the letter grade of the average score of all students
    public void calculateAndPrintAverageLetterGrade() {
        List<Student> students = Student.getStudentList();

        // Calculate the total score of all students
        int totalScore = 0;
        for (Student student : students) {
            totalScore += student.getGrade().getScore();
        }

        // Calculate the average score
        double averageScore = (double) totalScore / students.size();

        // Determine the letter grade corresponding to the average score
        String averageLetterGrade = determineLetterGrade(averageScore);

        // Print the average letter grade
        System.out.println("Average letter grade: " + averageLetterGrade);
    }

    // Method to determine the letter grade based on the average score
    private String determineLetterGrade(double averageScore) {
        for (int i = 0; i < gradeOrder.length; i++) {
            if (averageScore >= getLowerBound(i)) {
                return gradeOrder[i];
            }
        }
        // If the average score is below "F", return "F"
        return "F";
    }

    // Helper method to get the lower bound score for a letter grade index
    private int getLowerBound(int gradeIndex) {
        if (gradeIndex == 0) {
            return 0; // Lower bound for "A"
        } else {
            return (int) Math.ceil(getUpperBound(gradeIndex - 1));
        }
    }

    // Helper method to get the upper bound score for a letter grade index
    private double getUpperBound(int gradeIndex) {
        if (gradeIndex == gradeOrder.length - 1) {
            return Double.POSITIVE_INFINITY; // Upper bound for "F"
        } else {
            return (gradeIndex == 0) ? 100 : (gradeIndex * 10) - 0.1; // Adjust for non-"A" grades
        }
    }


    // Method to calculate and print the letter grade of the median score of all students
    public void calculateAndPrintMedianLetterGrade() {
        List<Student> students = Student.getStudentList();

        // Extract all scores into an array for sorting
        int[] scores = new int[students.size()];
        for (int i = 0; i < students.size(); i++) {
            scores[i] = students.get(i).getGrade().getScore();
        }

        // Sort the scores array
        Arrays.sort(scores);

        // Calculate the median score
        double medianScore;
        int middleIndex = scores.length / 2;
        if (scores.length % 2 == 0) {
            medianScore = (double) (scores[middleIndex - 1] + scores[middleIndex]) / 2;
        } else {
            medianScore = scores[middleIndex];
        }

        // Determine the letter grade corresponding to the median score
        String medianLetterGrade = determineLetterGrade(medianScore);

        // Print the median letter grade
        System.out.println("Median letter grade: " + medianLetterGrade);
    }


    // Method to calculate and print the list of all students in a tab-separated table
    public void printTabSeparatedTable() {
        List<Student> students = Student.getStudentList();

        // Print table header
        System.out.println("First Name\tLast Name\tPID\tLetter Grade");

        // Print student information
        for (Student student : students) {
            String firstName = student.getFirstName();
            String lastName = student.getLastName();
            String pid = Integer.toString(student.getPid());
            String letterGrade = student.getGrade().getLetterGrade();
            System.out.println(firstName + "\t" + lastName + "\t" + pid + "\t" + letterGrade);
        }


    }
}
