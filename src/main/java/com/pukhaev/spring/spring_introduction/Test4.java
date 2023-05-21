package com.pukhaev.spring.spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {
    public static void main(String[] args) {
        // Можно использовать несколько applicationContext файлов. их просто перечисляем через запятую "file1", "file2"
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
//
//        Dog myDog = context.getBean("myPet", Dog.class);
//        myDog.setName("Belka");
//        Dog yourDog = context.getBean("myPet", Dog.class);
//        yourDog.setName("Strelka");
//        // Если scope = singleton, то имя будет Strelka у обоих собак
//        System.out.println(myDog.getName());
//        System.out.println(yourDog.getName());
//        // Когда используем scope = singleton -- объкты ссылаются на одну ячейку памяти.
//        System.out.println("Переменные ссылаются на один и тот же объект? " + (myDog == yourDog));
//        System.out.println(myDog);
//        System.out.println(yourDog);
//
//        context.close();
    }
}
