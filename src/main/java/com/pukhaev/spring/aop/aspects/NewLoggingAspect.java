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
        Object targetMethodResult = null;
        try {
            targetMethodResult = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            System.out.println("aroundReturnBookLoggingAspect: было поймано исключение " + e);
            // Переназначение таргет метода
//            targetMethodResult = "Неизвестное название книги";

            // пробрасывание исключения дальше
            throw e;
        }
        System.out.println("aroundReturnBookLoggingAspect: в библиотеку успешно вернули книгу");
        return targetMethodResult;
    }
}
