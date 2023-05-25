package com.pukhaev.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        University university = context.getBean("university", University.class);
        university.addStudents();
        List<Student> students = university.getStudents();
        System.out.println(students);

        // After Returning Advice. Принцип работы:
        // 1. Логика метода
        // 2. Выполнение After Returning Advice
        // 3. Присвоение результата метода переменной

        context.close();
    }
}
