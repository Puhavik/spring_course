package com.pukhaev.spring.aop.aspects;

import com.pukhaev.spring.aop.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect  // Аспект класс отвечающий за сквозную функциональность
@Order(1)
public class LoggingAspect {
    // Pointcut -- ("execution(...)") показывает где и когда должен быть применен Advice
    // показывает когда должен выполниться сквозной код. Если не указано из какого класса метод, то метод будет вызываться для всех классов
    // com.pukhaev.spring.aop.UniLibrary. -- таким образом логгирование будет происходить для выбранного класса
    // execution(public void get*() -- логирование будет по всем методам с get во всех классах
    // когда стоит * это соответствует "любой"
    // когда в параметрах метода стоит *, то это любой ОДИН параметр, если нужно несколько любых параметров и/или без параметров ставим ".." (две точки)
    @Before("com.pukhaev.spring.aop.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature = " + methodSignature);
        System.out.println("methodSignature.getMethod = " + methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType = " + methodSignature.getReturnType());
        System.out.println("methodSignature.getName = " + methodSignature.getName());

        if (methodSignature.getName().equals("addBook")) {
            Object[] arguments = joinPoint.getArgs();
            for (Object obj : arguments) {
                if (obj instanceof Book) {
                    Book myBook = (Book) obj;
                    System.out.println("Информация о книге - " + myBook.getName() + ", автор - " + myBook.getAuthor() + ", год издания - " + myBook.getYearOfPublication());
                } else if (obj instanceof String) {
                    System.out.println("Книгу в библиотеку добавляет " + obj);
                }
            }
        }

        System.out.println("beforeAddLoggingAdvice: Логгирование опытки получить книгу / журнал");
        System.out.println("----------------------------------");

    }
//
//    @Pointcut("execution(* com.pukhaev.spring.aop.UniLibrary.*(..))")
//    private void allMethodsFromUniLibrary(){}
//
//    @Pointcut("execution(public void com.pukhaev.spring.aop.UniLibrary.returnMagazine())")
//    private void returnMagazineFromUniLibrary(){}
//
//    @Pointcut("allMethodsFromUniLibrary() && !returnMagazineFromUniLibrary()")
//    private void allMethodsExceptReturnFromUniLibrary(){}
//
//    @Before("allMethodsExceptReturnFromUniLibrary()")
//    public void beforeAllMethodsExceptReturnAdvice() {
//        System.out.println("beforeAllMethodsExceptReturnAdvice: writing Log #10");
//    }

//    @Pointcut("execution(* com.pukhaev.spring.aop.UniLibrary.get* ())")
//    private void allGetMethodsFromUniLibrary(){}
//
//    @Pointcut("execution(* com.pukhaev.spring.aop.UniLibrary.return* ())")
//    private void allReturnMethodsFromUniLibrary(){}
//
//    @Pointcut("allGetMethodsFromUniLibrary() || allReturnMethodsFromUniLibrary()")
//    private void allGetAndReturnMethodsFromUniLibrary(){}
//
//    @Before("allGetMethodsFromUniLibrary()")
//    public void beforeGetLoggingAdvice(){
//        System.out.println("beforeGetLoggingAdvice: writing Log #1");
//    }
//
//    @Before("allReturnMethodsFromUniLibrary()")
//    public void beforeReturnLoggingAdvice(){
//        System.out.println("beforeReturnLoggingAdvice: writing Log #2");
//    }
//
//    @Before("allGetAndReturnMethodsFromUniLibrary()")
//    public void beforeGetAndReturnLoggingAdvice(){
//        System.out.println("beforeGetAndReturnLoggingAdvice: writing Log #3");
//    }


    // Объявление Pointcut
//    @Pointcut("execution(* get*())")
//    private void allGetMethods() {
//    }


//    @Before("allGetMethods()")
//    public void beforeGetSecurityAdvice() {
//        System.out.println("beforeGetSecurityAdvice: проверка прав на получение книги / журнала");
//    }

    // Если нам не важен тип возврщаемых данных то можно заменть void на *
    // Access modifier не обязателен, поэтому его можно удалить или заменить на * и будет подходить метод с любыми правами доступа
//    @Before("execution(* returnBook())")
//    public void beforeReturnBookAdvice() {
//        System.out.println("beforeReturnBookAdvice: Попытка вернуть книгу");
//    }
}
