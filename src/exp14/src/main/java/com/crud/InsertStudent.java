package com.crud;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Student;
import com.util.HibernateUtil;

public class InsertStudent {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction tx = session.beginTransaction();

        Student s = new Student();

        s.setId(2);
        s.setName("Rahul Sharma");
        s.setCourse("MCA");
        s.setFees(55000);

        session.save(s);

        tx.commit();

        session.close();

        System.out.println("Student Inserted Successfully");
    }
}