package com.geekbrains.interwiev.Repository;

import com.geekbrains.interwiev.Entity.Student;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepo {

    @Getter
    @Setter
    private Session currentSession;
    private Transaction currentTransaction;

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionWithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionWithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }


    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        return sessionFactory;
    }

    public void persist(Student student) {
        getCurrentSession().save(student);
    }

    public void delete(int id) {
        getCurrentSession().delete(findById(id));
    }

    public Student findById(int id) {
        Student student = getCurrentSession().find(Student.class, id);
        return student;
    }

    @SuppressWarnings("unchecked")
    public List<Student> findAll() {
        List<Student> studentList = getCurrentSession().createQuery("from Student ").list();
        return studentList;
    }

    public void update(Student student) {
    getCurrentSession().update(student);
    }
}
