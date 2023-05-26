package com.pukhaev.spring.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {
    @Around("execution(* returnBook())")
    public Object aroundReturnBookLoggingAspect(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aroundReturnBookLoggingAspect: в библиотеку пытаются вернуть книгу");
        // вызов таргет метода. В advice @Around нужно самостоятельно вызывать таргет метод через proceedingJoinPoint.proceed()
        // .proceed возращет Object
        long begin = System.currentTimeMillis();
        Object targetMethodResult = proceedingJoinPoint.proceed();
//        targetMethodResult = "Преступление и Наказание";
        long end = System.currentTimeMillis();
        System.out.println("aroundReturnBookLoggingAspect: в библиотеку успешно вернули книгу");
        System.out.println("aroundReturnBookLoggingAspect: метод returnBook выполнил работу за " + (end - begin) + "мс");
        return targetMethodResult;
    }
}
