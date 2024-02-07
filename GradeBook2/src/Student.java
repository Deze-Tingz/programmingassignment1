import java.util.ArrayList;
import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private int pid;
    public Grade grade;





    // Static list to keep track of all student instances
    private static final List<Student> studentList = new ArrayList<>();

    // Constructor to initialize a new Student object
    public Student(String firstName, String lastName, int pid, Grade grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pid = pid;
        this.grade = grade;
        studentList.add(this); // Add the new Student object to the list
    }



    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPid() {
        return pid;
    }

    public Grade getGrade() {
        return grade;
    }

    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    // Static method to get the list of all students
    public static List<Student> getStudentList() {
        return studentList;
    }


}














//Summary
/*Static Student List: The studentList is made static so that it belongs to the class itself rather than each instance. This way, it can keep track of all Student instances.
Constructor: A constructor is added to initialize new Student objects with their details and add them to the studentList. This is more efficient than setting each field individually and then manually adding to the list.
Removed gradeValue: It seemed redundant to store gradeValue as a separate field since it can be accessed via grade.getScore(). If you need to frequently access the grade value, consider adding a method that returns grade.getScore() directly.
PID as String: Assuming the 7-digit ID should allow leading zeros, pid is kept as a String. If leading zeros are not required, you could change it to an int.
Assumed Grade Class: The Grade class is not defined in your snippet. Ensure that this class exists and has the necessary attributes and methods, like getScore().
*
* */