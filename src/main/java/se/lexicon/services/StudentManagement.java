package se.lexicon.services;

import se.lexicon.model.Student;

import java.util.List;

public interface StudentManagement {
    Student createStudent(String name);
    Student findStudent(int id);
    List<Student> findAllStudents();
    void editStudent(int id, String newName);
    void deleteStudent(int id);
}
