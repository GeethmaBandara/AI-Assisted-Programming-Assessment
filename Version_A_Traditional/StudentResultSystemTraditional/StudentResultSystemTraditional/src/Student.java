import java.util.ArrayList;
import java.util.List;
public class Student {
    private int id;
    private String name;
    private int programmingMark;
    private int databaseMark;
    private int mathematicsMark;
    private double average;
    private char grade;

    public Student(int id, String name ) {
                   /*int  programmingMark, int databaseMark, int mathematicsMark, double average, String grade */

        this.id = id;
        this.name = name;

    }
    public int getId() {return id;}
    public String getName() {return name;}
    public void setMarks(int programmingMark, int databaseMark, int mathematicsMark) {
        this.programmingMark = programmingMark;
        this.databaseMark = databaseMark;
        this.mathematicsMark = mathematicsMark;
    }
    public void calculateAverage() {
        average = (programmingMark + databaseMark + mathematicsMark) / 3.0;
    }
    public void calculateGrade() {
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
    public int getProgrammingMark() {return programmingMark;}

    public int getDatabaseMark() {return databaseMark;}

    public int getMathematicsMark() {return mathematicsMark;}

    public double getAverage() {return average;}

    public char getGrade() {return grade;}
    }
/*
    public void showDetails(){
        System.out.println("Student ID: "+id +
                "\nName: "+name+
                "\nprogrammingMark: "+programmingMark+
                "\ndatabaseMark"+databaseMark+
                "\nmathematicsMark: "+mathematicsMark+
                "\naverage: "+average+
                "\ngrade: "+grade);

    }*/

