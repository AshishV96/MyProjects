package com.example.demo.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GlobalExceptionHandler {
    @Pointcut(value = "execution(* com.example.demo..*.*(..))")
    public void afterPointcut() {}

    @After("afterPointcut()")
    public void after(JoinPoint joinPoint) {
        System.out.println("Printing the stack trace "+joinPoint.getSignature());
    }
}

