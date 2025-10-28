package com.pci.ex25branch.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ExceptionAspect {

    @AfterThrowing(pointcut = "execution(* com.pci.ex25branch.service.*.*(..))",throwing = "excep")
    public void logError(JoinPoint jp,Exception excep) {
       log.info("12345 메서드 실행전: {} rrrrrr \n rrrr {} rrrrr", jp.getSignature(), excep);
    }

}
