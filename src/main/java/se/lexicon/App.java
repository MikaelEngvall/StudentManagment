package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.ComponentScanConfig;
import se.lexicon.data_access.StudentDao;
import se.lexicon.model.Student;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        StudentDao studentDao = context.getBean(StudentDao.class);
        Student student = new Student("Test Testsson");
//        Student student2 = new Student("Test2 Test2sson");
//        Student student3 = new Student("Test3 Test3sson");
        studentDao.save(student);
//        studentDao.save(student2);
//        studentDao.save(student3);
//        System.out.println(student);
        System.out.println(studentDao.findAll());

    }
}
