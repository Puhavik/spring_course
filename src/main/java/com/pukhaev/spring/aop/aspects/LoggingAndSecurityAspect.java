package com.pukhaev.spring.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect  // Аспект класс отвечающий за сквозную функциональность
public class LoggingAndSecurityAspect {

    // Объявление Pointcut
    @Pointcut("execution(* get*())")
    private void allGetMethods(){}

    // Pointcut -- ("execution(...)") показывает где и когда должен быть применен Advice
    // показывает когда должен выполниться сквозной код. Если не указано из какого класса метод, то метод будет вызываться для всех классов
    // com.pukhaev.spring.aop.UniLibrary. -- таким образом логгирование будет происходить для выбранного класса
    // execution(public void get*() -- логирование будет по всем методам с get во всех классах
    // когда стоит * это соответствует "любой"
    // когда в параметрах метода стоит *, то это любой ОДИН параметр, если нужно несколько любых параметров и/или без параметров ставим ".." (две точки)
    @Before("allGetMethods()")
    public void beforeGetLoggingAdvice() {
        System.out.println("beforeGetLoggingAdvice: Попытка получить книгу / журнал");
    }

    @Before("allGetMethods()")
    public void beforeGetSecurityAdvice(){
        System.out.println("beforeGetSecurityAdvice: проверка прав на получение книги / журнала");
    }

    // Если нам не важен тип возврщаемых данных то можно заменть void на *
    // Access modifier не обязателен, поэтому его можно удалить или заменить на * и будет подходить метод с любыми правами доступа
//    @Before("execution(* returnBook())")
//    public void beforeReturnBookAdvice() {
//        System.out.println("beforeReturnBookAdvice: Попытка вернуть книгу");
//    }
}
