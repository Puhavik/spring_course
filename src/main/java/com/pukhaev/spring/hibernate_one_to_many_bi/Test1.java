package com.pukhaev.spring.hibernate_one_to_many_bi;

import com.pukhaev.spring.hibernate_one_to_many_bi.entity.Department;
import com.pukhaev.spring.hibernate_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session = null;
        try {
//            session = factory.getCurrentSession();
//
//            Department dep = new Department("Sales", 800, 1500);
//            Employee emp1 = new Employee("Zaur", "Tregulov", 800);
//            Employee emp2 = new Employee("Elena", "Smirnovs", 1500);
//            Employee emp3 = new Employee("Anton", "Sidorov", 1200);
//
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//            dep.addEmployeeToDepartment(emp3);
//
//            session.beginTransaction();
//
//            session.save(dep);
//
//            session.getTransaction().commit();
//            System.out.println("Done");
//----------------------------------------------------------------------

            session = factory.getCurrentSession();

            session.beginTransaction();

            System.out.println("Get department");
            Department dep = session.get(Department.class, 4);

            System.out.println("Show department");
            System.out.println(dep);

//            System.out.println("Show employees of the department");
//            System.out.println(dep.getEmps());

            System.out.println("Predownload employees");
            dep.getEmps().get(0);

            session.getTransaction().commit();

            System.out.println("Show employees of the department");
            System.out.println(dep.getEmps());

            System.out.println("Done");
//----------------------------------------------------------------------

//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Employee emp = session.get(Employee.class, 1);
//
//            System.out.println(emp);
//            System.out.println(emp.getDepartment());
//
//            session.getTransaction().commit();
//            System.out.println("Done");
//----------------------------------------------------------------------
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Employee emp = session.get(Employee.class, 4);
//
//            session.delete(emp);
//
//            session.getTransaction().commit();
//            System.out.println("Done");
        } finally {
            // предотвращаем connection leak
            assert session != null;
            session.close();
            factory.close();

        }
    }

}
