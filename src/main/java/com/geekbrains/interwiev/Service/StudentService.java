package com.geekbrains.interwiev.Service;

import com.geekbrains.interwiev.Entity.Student;
import com.geekbrains.interwiev.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {


    private StudentRepo studentRepo;

    @Autowired
    public void setStudentRepo(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public void persist(Student student) {
        studentRepo.openCurrentSessionWithTransaction();
        studentRepo.persist(student);
        studentRepo.closeCurrentSessionWithTransaction();
    }

    public void delete(int id) {
        studentRepo.openCurrentSessionWithTransaction();
        studentRepo.delete(id);
        studentRepo.closeCurrentSessionWithTransaction();
    }

    public List<Student> findAll() {
        studentRepo.openCurrentSession();
        List<Student> studentList = studentRepo.findAll();
        studentRepo.closeCurrentSession();
        return studentList;
    }

    public Student findById(int id) {
        studentRepo.openCurrentSession();
        Student student = studentRepo.findById(id);
        studentRepo.closeCurrentSession();
        return student;
    }

    public void update(Student student) {
        studentRepo.openCurrentSessionWithTransaction();
        studentRepo.update(student);
        studentRepo.closeCurrentSessionWithTransaction();
    }
}
