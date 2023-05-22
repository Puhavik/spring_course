package com.pukhaev.spring.spring_introduction;

import org.springframework.context.annotation.*;


// Способ 1
//@Configuration // нужно для создания spring container c помощью java code
//@ComponentScan("com.pukhaev.spring.spring_introduction")
//public class MyConfig {
//}

// Способ 2
@Configuration // нужно для создания spring container c помощью java code
@PropertySource("classpath:myApp.properties")
public class MyConfig {
    @Bean
    @Scope("singleton")
    public Pet catBean() {
        // System.out.println("test TWO cats");
        return new Cat();
    }

    @Bean
    public Person personBean() {
        return new Person(catBean());
    }

}
