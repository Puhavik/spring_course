package com.pukhaev.spring.hibernate_test2;


import com.pukhaev.spring.hibernate_test2.entity.Detail;
import com.pukhaev.spring.hibernate_test2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;
        try {
//            Session session = factory.getCurrentSession();
//            Employee employee = new Employee("Vik", "Puhaev", "IT", 500);
//            Detail detail = new Detail("Vienna", "88005553535", "krutoyemail@gmail.com");
//            employee.setEmpDetail(detail);
//
//            session.beginTransaction();
//            session.save(employee);
//
//            session.getTransaction().commit();
//            System.out.println("Done");

//            Session session = factory.getCurrentSession();
//            Employee employee = new Employee("Vik", "Puhaev", "IT", 500);
//            Detail detail = new Detail("Vienna", "88005553535", "bestemail@gmail.com");
//            employee.setEmpDetail(detail);
//
//            session.beginTransaction();
//            session.save(employee);
//
//            session.getTransaction().commit();
//            System.out.println("Done");

            session = factory.getCurrentSession();

            session.beginTransaction();
            Employee emp = session.get(Employee.class, 2);
            session.delete(emp);
            session.getTransaction().commit();
            System.out.println("Done");
        } finally {
            // предотвращаем connection leak
            assert session != null;
            session.close();
            factory.close();

        }
    }

}
