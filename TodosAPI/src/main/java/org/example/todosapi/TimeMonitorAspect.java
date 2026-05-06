package org.example.todosapi;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import javax.sound.midi.SysexMessage;

@Aspect
public class TimeMonitorAspect {

    @Before("@annotation(TimeMonitor)")
    public void Logtime(ProceedingJoinPoint joinPoint){
        System.out.println("Logging time");
        Long start = System.currentTimeMillis();
        try{
            joinPoint.proceed();
        }catch (Throwable e){
            System.out.println("something went wrng");
        }finally {
            Long end = System.currentTimeMillis();
            Long totalExecutionTime = end-start;
            System.out.println("Total execution Time "+ totalExecutionTime+" ms..");
        }

    }
}
