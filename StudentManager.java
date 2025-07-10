package service;

import model.Student;
import java.util.*;

public class StudentManager {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student s) throws Exception {
        for (Student st : students) {
            if (st.getStudentId() == s.getStudentId()) {
                throw new Exception("Duplicate Student ID!");
            }
        }
        if (s.getGpa() < 0.0 || s.getGpa() > 4.0) {
            throw new Exception("Invalid GPA range!");
        }
        students.add(s);
    }

    public boolean deleteStudent(int id) {
        return students.removeIf(s -> s.getStudentId() == id);
    }

    public List<Student> searchByName(String name) {
        List<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getFullName().toLowerCase().contains(name.toLowerCase())) {
                result.add(s);
            }
        }
        return result;
    }

    public void displayAll() {
        if (students.isEmpty()) {
            System.out.println("No student data.");
            return;
        }
        System.out.printf("%-10s %-20s %-5s\n", "ID", "Name", "GPA");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
