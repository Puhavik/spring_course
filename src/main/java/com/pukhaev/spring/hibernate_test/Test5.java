package com.pukhaev.spring.hibernate_test;

import com.pukhaev.spring.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test5 {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
//             Удаление одного объекта
//            Employee emp = session.get(Employee.class, 1);
//            session.delete(emp);

//             Удаление нескольких объектов
            session.createQuery("delete Employee where name = 'Alex'")
                    .executeUpdate();

            session.getTransaction().commit();
            System.out.println("Done");

        }
    }

}
