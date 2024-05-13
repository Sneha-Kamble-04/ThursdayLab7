package Studentsystem;
import java.util.Scanner;

abstract class Person //Abstract Class for Person
{
    protected String name;
    protected int id;

    public Person(String name, int id) 
    {
        this.name = name;
        this.id = id;
    }

    public String getName() 
    {
        return name;
    }

    public int getId() 
    {
        return id;
    }

    public abstract void displayDetails();//Abstfract method for displaying details
}

class Student extends Person //extends super class person 
{
    private double gpa;

    public Student(String name, int id, double gpa) // student constructoe with parameters
    {
        super(name, id);
        this.gpa = gpa;
    }

    @Override
    public void displayDetails() // Override abstract method 
    {
        System.out.println("Student ID: " + id + " | Name: " + name + " | GPA: " + gpa);
    }
}

public class StudentManagementSystem 
{
    private static final int MAX_STUDENTS = 50;
    private Student[] students;//student array for storing students data
    private int studentCount;

    public StudentManagementSystem()//student constructor 
    {
        students = new Student[MAX_STUDENTS];
        studentCount = 0;
    }

    public void addStudent(Student student) //Adding students informations
    {
        if (studentCount < MAX_STUDENTS) 
        {
            students[studentCount] = student;
            studentCount++;
            System.out.println("Student added successfully.");
        } 
        else 
        {
            System.out.println("Student list is full. Cannot add more students.");
        }
    }

    public void displayStudents() 
    {
        System.out.println("\nStudent List:");
        for (int i = 0; i < studentCount; i++) 
        {
            students[i].displayDetails();
        }
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem studentSystem = new StudentManagementSystem();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) 
            {
                case 1:
                    System.out.print("Enter Name: ");
                    scanner.nextLine(); // Consume the newline character
                    String name = scanner.nextLine();
                    System.out.print("Enter Student ID: ");
                    int studentId = scanner.nextInt();
                    System.out.print("Enter GPA: ");
                    double gpa = scanner.nextDouble();

                    Student newStudent = new Student(name, studentId, gpa);
                    studentSystem.addStudent(newStudent);
                    break;

                case 2:
                    studentSystem.displayStudents();
                    break;

                case 3:
                    System.out.println("Exiting the Student Management System. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
