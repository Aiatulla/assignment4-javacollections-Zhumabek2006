package service;

import model.Student;
import java.util.ArrayList;
import java.util.Iterator;

public class StudentService {

    private ArrayList<Student> students = new ArrayList<>();

    public void initializeStudents() {
        students.add(new Student(1, "Alice", 3.8));
        students.add(new Student(2, "Bob", 1.9));
        students.add(new Student(3, "Charlie", 3.5));
        students.add(new Student(4, "Diana", 1.5));
        students.add(new Student(5, "Eve", 3.9));
    }

    public void removeLowGPA() {
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            if (s.getGpa() < 2.0) {
                System.out.println("Removing: " + s);
                it.remove();
            }
        }
    }

    public void findHighestGPA() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        Student best = students.get(0);
        for (Student s : students) {
            if (s.getGpa() > best.getGpa()) {
                best = s;
            }
        }
        System.out.println("Student with highest GPA: " + best);
    }

    public void insertAtIndex() {
        Student newStudent = new Student(6, "Frank", 3.2);
        students.add(2, newStudent);
        System.out.println("Inserted at index 2: " + newStudent);
    }

    public void printStudents() {
        System.out.println("=== All Students ===");
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
