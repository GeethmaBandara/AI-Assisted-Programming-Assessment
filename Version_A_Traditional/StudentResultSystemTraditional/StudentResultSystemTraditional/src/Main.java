import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        int choice;

        do {
            System.out.println("\n=========================================");
            System.out.println("    STUDENT RESULT MANAGEMENT SYSTEM");
            System.out.println("=========================================");
            System.out.println("1. Add Student");
            System.out.println("2. Enter Student Marks");
            System.out.println("3. View Student Result");
            System.out.println("4. Search Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();

                    Student newStudent = new Student(id, name);
                    manager.addStudent(newStudent);
                    break;

                case 2:
                    System.out.print("Enter Student ID: ");
                    int markStudentId = scanner.nextInt();

                    Student markStudent = manager.searchStudent(markStudentId);

                    if (markStudent != null) {
                        System.out.print("Enter Programming Mark: ");
                        int programmingMark = scanner.nextInt();

                        System.out.print("Enter Database Mark: ");
                        int databaseMark = scanner.nextInt();

                        System.out.print("Enter Mathematics Mark: ");
                        int mathematicsMark = scanner.nextInt();

                        markStudent.setMarks(
                                programmingMark,
                                databaseMark,
                                mathematicsMark
                        );

                        markStudent.calculateAverage();
                        markStudent.calculateGrade();

                        System.out.println("Marks added successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    int resultStudentId = scanner.nextInt();

                    Student resultStudent = manager.searchStudent(resultStudentId);

                    if (resultStudent != null) {
                        System.out.println("\n================================");
                        System.out.println("        STUDENT RESULT");
                        System.out.println("================================");

                        System.out.println("Student ID: " + resultStudent.getId());
                        System.out.println("Student Name: " + resultStudent.getName());
                        System.out.println("Programming Mark: "
                                + resultStudent.getProgrammingMark());
                        System.out.println("Database Mark: "
                                + resultStudent.getDatabaseMark());
                        System.out.println("Mathematics Mark: "
                                + resultStudent.getMathematicsMark());

                        System.out.printf(
                                "Average: %.2f%n",
                                resultStudent.getAverage()
                        );

                        System.out.println("Grade: " + resultStudent.getGrade());
                        System.out.println("================================");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Student ID: ");
                    int searchId = scanner.nextInt();

                    Student searchedStudent = manager.searchStudent(searchId);

                    if (searchedStudent != null) {
                        System.out.println("Student Found");
                        System.out.println("Student ID: "
                                + searchedStudent.getId());
                        System.out.println("Student Name: "
                                + searchedStudent.getName());
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    manager.displayAllStudents();
                    break;

                case 6:
                    System.out.println(
                            "Thank you for using the Student Result Management System."
                    );
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        scanner.close();
    }
}