package com.pci.ex25branch.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class PerformanceAspect {

    @Around("execution(* com.pci.ex25branch.service.*.*(..))")
    public Object measureTime(ProceedingJoinPoint pjp) throws Throwable{

        long start = System.currentTimeMillis();
        Object result = pjp.proceed();
        long end = System.currentTimeMillis();
        log.info("<<<<<abcde>>>>> 메서드 실행시간: {} >>>>>>> \n <<<<<rasdb>>>> {} >>>>", pjp.getSignature(), (end-start));
        return  result;
    }
}
