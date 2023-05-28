package com.pukhaev.spring.hibernate_test;

import com.pukhaev.spring.hibernate_test.entity.Employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test4 {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            // Изменение поля для одной строки
//            Employee emp = session.get(Employee.class, 8);
//            emp.setSalary(1500);

            // Изменение поля для нескольких строк
            session.createQuery("update Employee set salary = 1000  where name = 'Alex'")
                            .executeUpdate();


            session.getTransaction().commit();
            System.out.println("Done");

        }
    }

}
