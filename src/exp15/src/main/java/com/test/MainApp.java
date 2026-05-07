package com.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Department;
import com.entity.Employee;
import com.util.HibernateUtil;

public class MainApp {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction tx = session.beginTransaction();

        Employee e1 = new Employee();
        e1.setEmpId(101);
        e1.setEmpName("Jivan");
        e1.setSalary(50000);

        Employee e2 = new Employee();
        e2.setEmpId(102);
        e2.setEmpName("Shrimant");
        e2.setSalary(60000);

        List<Employee> empList = new ArrayList<>();
        empList.add(e1);
        empList.add(e2);

        Department dept = new Department();
        dept.setDeptId(1);
        dept.setDeptName("IT");
        dept.setEmployees(empList);

        session.persist(dept);

        tx.commit();

        session.close();

        System.out.println("One-To-Many Relationship Inserted Successfully");
    }
}