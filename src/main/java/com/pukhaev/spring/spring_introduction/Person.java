package com.pukhaev.spring.spring_introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("personBean")
public class Person {
    // Использование аннотации Autowired возможно в поле. Работает через рефлексию Java
//    @Autowired
//    @Qualifier("catBean") // Если есть несколько бинов с аннотацией Autwired, то у одного нужно прописывать Qualifier (делает его дефолтным), чтобы не было ошибок
    private Pet pet;
    //    @Value("Pukhaev") // Хардкод вариант
//    @Value("${person.surname}")
    private String surname;
    //    @Value("22") // Хардкод вариант
//    @Value("${person.age}")
    private int age;

    // внедрение зависимости с помощью конструктора
    // @Autowired -- внедрение зависимости с помощью аннотации. Со spring 4.3 если в классе 1 конструктор, то можно не прописывать Autowired
    // @Qualifier в конструктое пишется иначе!
    @Autowired
    public Person(@Qualifier("dog") Pet pet) {
        System.out.println("Person bean is created");
        this.pet = pet;
    }

//    public Person() {
//        System.out.println("Person bean is created");
//    }

    // в applicationContext pet -> setPet
    // Autowired можно вызывать на любом методе
//     @Autowired
//     @Qualifier("dog")
    public void setPet(Pet pet) {
        System.out.println("Class Person: set Pet");
        this.pet = pet;
    }

    public void setSurname(String surname) {
        System.out.println("Class Person: set surname");
        this.surname = surname;
    }

    public void setAge(int age) {
        System.out.println("Class Person: set age");
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public void callYourPet() {
        System.out.println("Hey, my dear Pet!");
        pet.say();
    }
}
