import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final InputValidator inputValidator =
            new InputValidator(scanner);
    private static final StudentManager studentManager =
            new StudentManager();

    public static void main(String[] args) {
        int choice;
        do {
            displayMenu();
            choice = inputValidator.readInteger("Enter your choice: ");
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    enterMarks();
                    break;
                case 3:
                    viewStudentResult();
                    break;
                case 4:
                    searchStudent();
                    break;
                case 5:
                    studentManager.displayAllStudents();
                    break;
                case 6:
                    System.out.println("Thank you for using the Student Result Management System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a number from 1 to 6.");
            }
        } while (choice != 6);
        scanner.close();
    }
    private static void displayMenu() {
        System.out.println("\n=========================================");
        System.out.println("    STUDENT RESULT MANAGEMENT SYSTEM");
        System.out.println("=========================================");
        System.out.println("1. Add Student");
        System.out.println("2. Enter Student Marks");
        System.out.println("3. View Student Result");
        System.out.println("4. Search Student");
        System.out.println("5. Display All Students");
        System.out.println("6. Exit");
    }
    private static void addStudent() {
        int id = inputValidator.readInteger("Enter Student ID: ");
        String name = inputValidator.readNonEmptyString("Enter Student Name: ");
        Student student = new Student(id, name);
        boolean added = studentManager.addStudent(student);
        if (added) {
            System.out.println("Student added successfully.");
        } else {
            System.out.println("Error: Student ID already exists.");
        }
    }
    private static void enterMarks() {
        int id = inputValidator.readInteger("Enter Student ID: ");
        Student student = studentManager.searchStudent(id);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        int programmingMark = inputValidator.readMark("Enter Programming Mark: ");
        int databaseMark = inputValidator.readMark("Enter Database Mark: ");
        int mathematicsMark = inputValidator.readMark("Enter Mathematics Mark: ");
        student.setMarks(
                programmingMark,
                databaseMark,
                mathematicsMark);
        System.out.println("Marks added successfully.");
    }
    private static void viewStudentResult() {
        int id = inputValidator.readInteger("Enter Student ID: ");
        Student student = studentManager.searchStudent(id);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.println("\n================================");
        System.out.println("        STUDENT RESULT");
        System.out.println("================================");
        System.out.println("Student ID: " + student.getId());
        System.out.println("Student Name: " + student.getName());
        System.out.println("Programming Mark: " + student.getProgrammingMark());
        System.out.println("Database Mark: "+ student.getDatabaseMark());
        System.out.println("Mathematics Mark: " + student.getMathematicsMark());
        System.out.printf("Average: %.2f%n", student.getAverage());
        System.out.println("Grade: " + student.getGrade());
        System.out.println("================================");
    }
    private static void searchStudent() {
        int id = inputValidator.readInteger("Enter Student ID: ");
        Student student = studentManager.searchStudent(id);
        if (student != null) {
            System.out.println("Student Found");
            System.out.println("Student ID: " + student.getId());
            System.out.println("Student Name: " + student.getName());
        } else {
            System.out.println("Student not found.");
        }
    }
}