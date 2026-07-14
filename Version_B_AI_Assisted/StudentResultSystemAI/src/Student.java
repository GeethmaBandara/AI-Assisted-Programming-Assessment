public class Student {

    private final int id;
    private final String name;

    private int programmingMark;
    private int databaseMark;
    private int mathematicsMark;

    private double average;
    private char grade;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setMarks(int programmingMark,
                         int databaseMark,
                         int mathematicsMark) {

        this.programmingMark = programmingMark;
        this.databaseMark = databaseMark;
        this.mathematicsMark = mathematicsMark;

        calculateAverage();
        calculateGrade();
    }

    private void calculateAverage() {
        average = (programmingMark
                + databaseMark
                + mathematicsMark) / 3.0;
    }

    private void calculateGrade() {

        if (average >= 75) {
            grade = 'A';
        } else if (average >= 65) {
            grade = 'B';
        } else if (average >= 55) {
            grade = 'C';
        } else if (average >= 45) {
            grade = 'D';
        } else {
            grade = 'F';
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getProgrammingMark() {
        return programmingMark;
    }

    public int getDatabaseMark() {
        return databaseMark;
    }

    public int getMathematicsMark() {
        return mathematicsMark;
    }

    public double getAverage() {
        return average;
    }

    public char getGrade() {
        return grade;
    }
}