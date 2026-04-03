package com.student.model;

import java.util.*;
import java.util.stream.*;

public class StudentResultProcessing {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        try {
            System.out.print("Enter number of students: ");
            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                try {
                    System.out.println("\nEnter details of student " + (i + 1));

                    System.out.print("Roll No: ");
                    int rollNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Standard: ");
                    int standard = sc.nextInt();

                    System.out.print("Marks: ");
                    double marks = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Section: ");
                    String section = sc.nextLine();

                    students.add(new Student(rollNo, name, standard, marks, section));

                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please re-enter student data.");
                    sc.nextLine();
                    i--; // retry
                }
            }

            int choice;
            do {
                System.out.println("\n===== MENU =====");
                System.out.println("1. Passed Students");
                System.out.println("2. Top 3 Students");
                System.out.println("3. Group Students by Section");
                System.out.println("4. Count Students Section-wise");
                System.out.println("5. Average Marks by Section");
                System.out.println("6. Student Names in Uppercase");
                System.out.println("7. Check Full Marks");
                System.out.println("8. Exit");

                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                switch (choice) {

                case 1:
                    try {
                        System.out.print("Enter passing marks: ");
                        double passMarks = sc.nextDouble();

                        System.out.println("\nPassed Students:");
                        students.stream()
                                .filter(s -> s.getMarks() >= passMarks)
                                .forEach(System.out::println);

                    } catch (InputMismatchException e) {
                        System.out.println("Invalid marks input!");
                        sc.nextLine();
                    }
                    break;

                case 2:
                    System.out.println("\nTop 3 Students:");
                    students.stream()
                            .sorted(Comparator.comparing(Student::getMarks).reversed())
                            .limit(3)
                            .forEach(System.out::println);
                    break;

                case 3:
                    Map<String, List<Student>> grouped = students.stream()
                            .collect(Collectors.groupingBy(Student::getSection));

                    grouped.forEach((sec, list) -> {
                        System.out.println(sec + ":");
                        list.forEach(System.out::println);
                    });
                    break;

                case 4:
                    Map<String, Long> count = students.stream()
                            .collect(Collectors.groupingBy(Student::getSection, Collectors.counting()));

                    count.forEach((sec, c) -> System.out.println(sec + " : " + c));
                    break;

                case 5:
                    Map<String, Double> avg = students.stream()
                            .collect(Collectors.groupingBy(
                                    Student::getSection,
                                    Collectors.averagingDouble(Student::getMarks)
                            ));

                    avg.forEach((sec, a) -> System.out.println(sec + " : " + a));
                    break;

                case 6:
                    System.out.println("\nUppercase Names:");
                    students.stream()
                            .map(s -> s.getName().toUpperCase())
                            .forEach(System.out::println);
                    break;

                case 7:
                    boolean hasFull = students.stream()
                            .anyMatch(s -> s.getMarks() == 100);

                    System.out.println("Any student scored full marks? " + hasFull);
                    break;

                case 8:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice.");
                }

            } while (choice != 8);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}