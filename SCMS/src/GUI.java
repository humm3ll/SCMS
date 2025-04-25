// GUI.java
// Written by Ethan Hulme
// Last edited: 23rd April 2023
// Class to create the graphical user interface

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private JTextField studentIdField; // Field for entering the Student ID
    private JTextField studentNameField; // Field for entering the Student Name
    private JTextArea outputArea; // Area to display the output messages
    private JTextField roomNumberField; // Field for entering the Room Number
    private JTextField resourceTitleField; // Field for entering the Resource Title

    public GUI() {
        // Set up the main frame
        setTitle("Smart Campus Management System");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create tabs for different functionalities
        JTabbedPane tabbedPane = new JTabbedPane();

        // Student Management Tab
        JPanel studentPanel = new JPanel();
        studentPanel.setLayout(new FlowLayout());
        studentPanel.add(new JLabel("Student ID:"));
        studentIdField = new JTextField(10);
        studentPanel.add(studentIdField);
        studentPanel.add(new JLabel("Student Name:"));
        studentNameField = new JTextField(10);
        studentPanel.add(studentNameField);
        JButton addStudentButton = new JButton("Add Student");
        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = studentIdField.getText();
                String name = studentNameField.getText();
                String result = Student.addStudent(id, name);
                outputArea.append(result + "\n"); // Display result
                studentIdField.setText(""); // Clear input field
                studentNameField.setText(""); // Clear input field
            }
        });
        studentPanel.add(addStudentButton);
        JButton viewStudentsButton = new JButton("View All Students");
        viewStudentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputArea.setText(Student.getAllStudents()); // Display all students
            }
        });
        studentPanel.add(viewStudentsButton);
        tabbedPane.addTab("Student Management", studentPanel);

        // Room Management Tab
        JPanel roomPanel = new JPanel();
        roomPanel.setLayout(new FlowLayout());
        roomPanel.add(new JLabel("Room Number:"));
        roomNumberField = new JTextField(10);
        roomPanel.add(roomNumberField);
        JButton bookRoomButton = new JButton("Book Room");
        bookRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String roomNumber = roomNumberField.getText();
                Room room = new Room(roomNumber);
                String result = room.bookRoom();
                outputArea.append(result + "\n"); // Display result
            }
        });
        roomPanel.add(bookRoomButton);
        JButton releaseRoomButton = new JButton("Release Room");
        releaseRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String roomNumber = roomNumberField.getText();
                Room room = new Room(roomNumber);
                String result = room.releaseRoom();
                outputArea.append(result + "\n"); // Display result
            }
        });
        roomPanel.add(releaseRoomButton);
        tabbedPane.addTab("Room Management", roomPanel);

        // Resource Management Tab
        JPanel resourcePanel = new JPanel();
        resourcePanel.setLayout(new FlowLayout());
        resourcePanel.add(new JLabel("Resource Title:"));
        resourceTitleField = new JTextField(10);
        resourcePanel.add(resourceTitleField);
        JButton addResourceButton = new JButton("Add Resource");
        addResourceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = resourceTitleField.getText();
                new Resource(title); // Add resource
                outputArea.append("Resource added: " + title + "\n"); // Display result
                resourceTitleField.setText(""); // Clear input field
            }
        });
        resourcePanel.add(addResourceButton);
        JButton borrowResourceButton = new JButton("Borrow Resource");
        borrowResourceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = resourceTitleField.getText();
                Resource resource = new Resource(title);
                String result = resource.borrowResource();
                outputArea.append(result + "\n"); // Display result
            }
        });
        resourcePanel.add(borrowResourceButton);
        JButton returnResourceButton = new JButton("Return Resource");
        returnResourceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = resourceTitleField.getText();
                Resource resource = new Resource(title);
                String result = resource.returnResource();
                outputArea.append(result + "\n"); // Display result
            }
        });
        resourcePanel.add(returnResourceButton);
        tabbedPane.addTab("Resource Management", resourcePanel);

        // Output Area
        outputArea = new JTextArea(15, 50);
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.SOUTH);
        add(tabbedPane, BorderLayout.CENTER);
    }
}