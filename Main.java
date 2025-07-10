package main;

import model.Student;
import service.StudentManager;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Search");
            System.out.println("4. Display All");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("GPA: ");
                        double gpa = sc.nextDouble();
                        sc.nextLine();
                        manager.addStudent(new Student(id, name, gpa));
                        break;
                    case 2:
                        System.out.print("Enter ID to delete: ");
                        int delId = sc.nextInt();
                        sc.nextLine();
                        if (!manager.deleteStudent(delId)) {
                            System.out.println("Student not found.");
                        }
                        break;
                    case 3:
                        System.out.print("Enter name to search: ");
                        String keyword = sc.nextLine();
                        manager.searchByName(keyword).forEach(System.out::println);
                        break;
                    case 4:
                        manager.displayAll();
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
