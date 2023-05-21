package com.pukhaev.spring.spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {
    public static void main(String[] args) {

        // Создаем без использования Spring:
//        Pet pet = new Dog();
//        Person person = new Person(pet);
//        person.callYourPet();

//        Используем Spring container БЕЗ созданного Person в applicationContext
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Pet pet2 = context.getBean("myPet", Pet.class);
//        Person person2 = new Person(pet2);
//        person2.callYourPet();

        // Используем Spring container C созданного Person в applicationContext
        // Spring container сам внедряет зависимости между классами
        Person person3 = context.getBean("myPerson", Person.class);
        person3.callYourPet();
        // В applicationContext можно менять местями dog и cat, чтобы отзывались разные животные

        System.out.println(person3.getSurname());
        System.out.println(person3.getAge());

        context.close();
    }
}
