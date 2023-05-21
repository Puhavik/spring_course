package com.pukhaev.spring.spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test5 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");

        Dog myDog = context.getBean("myPet", Dog.class);
        myDog.say();
        Dog yourDog = context.getBean("myPet", Dog.class);
        yourDog.say();

        // Так как scope = singleton, то init и destroy методы будут вызываться по одному разу. Если scope = prototype, то init будет вызываться
        // несколько раз, но не будет вызываться destroy
        context.close();
    }
}
