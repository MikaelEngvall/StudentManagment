package se.lexicon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.data_access.StudentDao;
import se.lexicon.model.Student;
import se.lexicon.utils.UserInputService;

import java.util.List;

@Component
public class StudentManagementConsoleImpl implements StudentManagement {
    private final StudentDao studentDao;
    private final UserInputService userInputService;

    @Autowired
    public StudentManagementConsoleImpl(StudentDao studentDao, UserInputService userInputService) {
        this.studentDao = studentDao;
        this.userInputService = userInputService;
    }

    @Override
    public Student createStudent(String name) {
        Student student = new Student(name);
        studentDao.save(student);
        return student;
    }

    @Override
    public Student findStudent(int id) {
        return studentDao.find(id);
    }

    @Override
    public List<Student> findAllStudents() {
        return studentDao.findAll();
    }

    @Override
    public void deleteStudent(int id) {
        studentDao.delete(id);
    }

    @Override
    public void editStudent(int id, String newName) {
        Student student = studentDao.find(id);
        if (student != null) {
            student.setName(newName);
        } else {
            System.out.println("Student not found.");
        }
    }
}
