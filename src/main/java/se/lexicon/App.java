package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.ComponentScanConfig;
import se.lexicon.data_access.StudentDao;
import se.lexicon.model.Student;
import se.lexicon.services.StudentManagement;
import se.lexicon.utils.UserInputService;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        StudentDao studentDao = context.getBean(StudentDao.class);
        UserInputService userInputService = context.getBean(UserInputService.class);
//        Student student = new Student("Test Testsson");
//        Student student2 = new Student("Test2 Test2sson");
//        Student student3 = new Student("Test3 Test3sson");
//        studentDao.save(student);
//        studentDao.save(student2);
//        studentDao.save(student3);
//        System.out.println(student);
//        System.out.println(studentDao.findAll());
//        studentDao.delete(2);
//        System.out.println(studentDao.find(1));
//        String userInput = userInputService.getString();
//        System.out.println("User input: " + userInput);
//
//        context.close(); // Close the context when you're done
        // Get the StudentManagement and UserInputService beans
        StudentManagement studentManagement = context.getBean(StudentManagement.class);

        // Example usage:
        while (true) {
            System.out.println("1. Create Student");
            System.out.println("2. Find Student");
            System.out.println("3. List All Students");
            System.out.println("4. Delete Student");
            System.out.println("5. Edit Student");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");
            String choice = userInputService.getString();

            switch (choice) {
                case "1":
                    System.out.print("Enter the student's name: ");
                    String name = userInputService.getString();
                    Student createdStudent = studentManagement.createStudent(name);
                    System.out.println("Student created: " + createdStudent);
                    break;
                case "2":
                    System.out.print("Enter the student's ID: ");
                    int idToFind = Integer.parseInt(userInputService.getString());
                    Student foundStudent = studentManagement.findStudent(idToFind);
                    if (foundStudent != null) {
                        System.out.println("Found Student: " + foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case "3":
                    System.out.println("List of All Students:");
                    for (Student student : studentManagement.findAllStudents()) {
                        System.out.println(student);
                    }
                    break;
                case "4":
                    System.out.print("Enter the student's ID to delete: ");
                    int idToDelete = Integer.parseInt(userInputService.getString());
                    studentManagement.deleteStudent(idToDelete);
                    System.out.println("Student deleted.");
                    break;
                case "5":
                    System.out.print("Enter the student's ID to edit: ");
                    int idToEdit = Integer.parseInt(userInputService.getString());
                    System.out.print("Enter the new name: ");
                    String newName = userInputService.getString();
                    studentManagement.editStudent(idToEdit, newName);
                    System.out.println("Student updated.");
                    break;
                case "0":
                    System.out.println("Exiting...");
                    context.close(); // Close the Spring context
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

