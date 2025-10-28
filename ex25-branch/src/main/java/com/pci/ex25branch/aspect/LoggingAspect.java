package com.pci.ex25branch.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.pci.ex25branch.service.*.*(..))")
    public void logBefore(JoinPoint jp){
        log.info("---메서드 실행전: {} mmmmmm", jp.getSignature());
    }

//    @AfterReturning(pointcut = "execution(* com.pci.ex25branch.service.*.*(..))",returning = "result")
//    public void logAfter(JoinPoint jp, Object result){
//        log.info("WWWWW 메서드 실행성공: {} wwwww \n wwwww {} wwwww", jp.getSignature(),result);
//
//    }


}
