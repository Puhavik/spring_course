package com.pukhaev.spring.spring_introduction;

public class Dog implements Pet {
    //    private String name;
    public Dog() {
        System.out.println("Dog bean is created");
    }

    @Override
    public void say() {
        System.out.println("Wow-Wow");
    }

//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }


    // access modifier и return type могут быть любыми
    public void init() {
        System.out.println("Class Dog: init method");
    }

    // access modifier и return type могут быть любыми
    public void destroy() {
        System.out.println("Class Dog: destroy method");
    }
}

