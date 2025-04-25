// Student.java
// Written by Filipe Ramos
// Last edited: 23rd April 205
// Class to manage student records

import java.util.ArrayList;

public class Student {
    private String id; // Student ID
    private String name; // Student name

    // Static list to store student records
    private static ArrayList<Student> studentList = new ArrayList<>();

    // Constructor
    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Method to add a student
    public static String addStudent(String id, String name) {
        for (Student student : studentList) {
            if (student.id.equals(id)) {
                return "Student ID already exists."; // Prevent duplicate IDs
            }
        }
        studentList.add(new Student(id, name));
        return "Student added successfully."; // Success message
    }

    // Method to search for a student by ID
    public static Student searchStudent(String id) {
        for (Student student : studentList) {
            if (student.id.equals(id)) {
                return student; // Return the found student
            }
        }
        return null; // Return null if not found
    }

    // Method to get all students as a string
    public static String getAllStudents() {
        StringBuilder result = new StringBuilder();
        for (Student student : studentList) {
            result.append("ID: ").append(student.id).append(", Name: ").append(student.name).append("\n");
        }
        return result.toString();
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}