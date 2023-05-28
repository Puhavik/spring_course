package com.pukhaev.spring.hibernate_test;

import com.pukhaev.spring.hibernate_test.entity.Employee;

// необходим hibernate-core версии 5.x.x
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {

        // Старый вариант написания

//        SessionFactory factory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Employee.class)
//                .buildSessionFactory())
//        try {
//            Session session = factory.getCurrentSession();
////            Employee emp = new Employee("Vik", "Pukhaev", "IT", 500);
//            Employee emp = new Employee("Alex", "John", "HR", 300);
//
//            session.beginTransaction();
//            session.save(emp);
//            session.getTransaction().commit();
//        } finally {
//            factory.close();
//        }

        // Новый вариант написания доступный с Hibernate версии 5.0.0
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            // получаем список всех работников. Несмотря на подчеркивания код работает.
//            List<Employee> emps = session
//                    .createQuery("from Employee", Employee.class)
//                    .getResultList();

            // получаем работников с определенным именем
            // Employee это название класса, name это названия поля в классе employee
            List<Employee> emps = session
                    .createQuery("from Employee where name = 'Vik' and salary > 400 ", Employee.class)
                    .getResultList();

            for (Employee e : emps) {
                System.out.println(e);
            }
            session.getTransaction().commit();
            System.out.println("Done");

            // Если нужно сделать несколько действий с таблицой, напримерр ADD и потом SELECT, то можно использовать только одну транзацию
        }
    }

}
