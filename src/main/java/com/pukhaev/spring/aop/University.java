package com.pukhaev.spring.aop;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {
    private final List<Student>  students = new ArrayList<>();

    public void addStudents(){
        Student st1 = new Student("Vik Pukhaev",  4, 7.5);
        Student st2 = new Student("Jack Daniels",  6, 4.3);
        Student st3  = new Student("Alex Black",  2, 8.9);
        students.add(st1);
        students.add(st2);
        students.add(st3);
    }

    public List<Student> getStudents(){
        System.out.println("Начало работы метода getStudents");
//        System.out.println(students.get(3));
        System.out.println("Information from getStudents: ");
        System.out.println(students);
        return students;
    }
}
