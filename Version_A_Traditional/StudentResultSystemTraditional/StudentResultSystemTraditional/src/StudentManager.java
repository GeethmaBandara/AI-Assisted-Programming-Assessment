import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public Student searchStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("======================================================");
        System.out.printf("%-10s %-20s %-10s %-10s%n",
                "ID", "NAME", "AVERAGE", "GRADE");
        System.out.println("======================================================");

        for (Student student : students) {
            System.out.printf("%-10d %-20s %-10.2f %-10c%n",
                    student.getId(),
                    student.getName(),
                    student.getAverage(),
                    student.getGrade());
        }

        System.out.println("======================================================");
    }
}