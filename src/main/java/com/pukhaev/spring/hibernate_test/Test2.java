package com.pukhaev.spring.hibernate_test;

import com.pukhaev.spring.hibernate_test.entity.Employee;

// необходим hibernate-core версии 5.x.x
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
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
            Employee emp = new Employee("Oleg", "Sidorov", "HR ", 700 );

            session.beginTransaction();
            session.save(emp);
//            session.getTransaction().commit();

            int myID = emp.getId();
//            session = factory.getCurrentSession();
//            session.beginTransaction();
            Employee employee = session.get(Employee.class, myID); // получаем строку из таблицы == SELECT
            session.getTransaction().commit();
            System.out.println(employee);
            System.out.println("Done");

            // Если нужно сделать несколько действий с таблицой, напримерр ADD и потом SELECT, то можно использовать только одну транзацию
        }
    }

}
