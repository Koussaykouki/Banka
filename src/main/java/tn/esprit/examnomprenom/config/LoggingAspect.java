package tn.esprit.examnomprenom.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Aspect
@Slf4j
public class LoggingAspect {
    @Before("execution(* tn.esprit.examnomprenom.services.*.get*(..))")
    public void logMethod(JoinPoint joinPoint){
        log.info(LocalDate.now()+"/- "+joinPoint.getSignature().getName());
    }
}
