//package Service;
//
//import Entity.Student;
//import Repository.StudentRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class StudentService {
//
//
//    private StudentRepo studentRepo;
//
//    @Autowired
//    public void setStudentRepo(StudentRepo studentRepo) {
//        this.studentRepo = studentRepo;
//    }
//
//    public void persist(Student student) {
//        studentRepo.openCurrentSessionWithTransaction();
//        studentRepo.persist(student);
//        studentRepo.closeCurrentSessionWithTransaction();
//    }
//
//    public void delete(int id) {
//        studentRepo.openCurrentSessionWithTransaction();
//        studentRepo.delete(id);
//        studentRepo.closeCurrentSessionWithTransaction();
//    }
//
//    public List<Student> findAll() {
//        studentRepo.openCurrentSession();
//        List<Student> studentList = studentRepo.findAll();
//        studentRepo.closeCurrentSession();
//        return studentList;
//    }
//
//    public void update(Student student) {
//        studentRepo.openCurrentSessionWithTransaction();
//        studentRepo.update(student);
//        studentRepo.closeCurrentSessionWithTransaction();
//    }
//}
