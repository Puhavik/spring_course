package com.pukhaev.spring.spring_introduction;


import org.springframework.stereotype.Component;
// Если не прописывать id Component, то имя будет создоваться автоматически. Имя класса с маленькой буквы Cat -> cat
@Component("catBean")
public class Cat implements Pet {
    public Cat() {
        System.out.println("Cat bean is created");
    }

    @Override
    public void say() {
        System.out.println("Meow-Meow ");
    }
}

// Test
