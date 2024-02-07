

/*
 Description: Keeps a list of students info in the following data structure:
java.util.ArrayList{Student}.

*/

import java.util.ArrayList;
import java.util.Arrays;

public class GradeBook {
    private ArrayList<Student> listOfStudents;


    public double calculateAvg() {
        double sum = 0;
        for(Student s: listOfStudents)
            sum += s.getGrade().getScore();
        return sum / listOfStudents.size();
    }
    public float calculateMedian() {
        int i = 0, n = listOfStudents.size();
        int[] scores = new int[n];
        for(Student s: listOfStudents)
            scores[i++] = s.getGrade().getScore();
        Arrays.sort(scores);
        if (n % 2 == 0)
            return (scores[n / 2] + scores[n / 2 - 1]) / 2.0f;
        else
            return scores[n / 2];
    }
    public void printAllStudents() {
        for(Student s: listOfStudents)
            System.out.printf("%s\t%s\t%d\t%d\n", s.getFirstName(), s.getLastName(), s.getPid(), s.getGrade().getScore());
    }
}
