package com.dekankilic.filter_aspect_interceptor.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Aspect
public class PerformanceTrackingAspect {

    // PointCut - What kind of method calls do you want to intercept?
    @Around("execution(* com.dekankilic.filter_aspect_interceptor.service.*.*(..))") // When? Do something before and after a method execution
    public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable { // JoinPoint - A specific execution of an advice is called JoinPoint.
        // Start a timer
        long startTimeMillis = System.currentTimeMillis();
        // Execute the method
        Object returnValue = proceedingJoinPoint.proceed();
        // Stop the timer
        long stopTimeMillis = System.currentTimeMillis();

        long executionDuration = stopTimeMillis - startTimeMillis;
        if(executionDuration > 5)
            log.info("Around Aspect - {} Method executed in {} ms", proceedingJoinPoint.getSignature() , executionDuration);      // Advice - What code to execute is called Advice, logging, authentication // What?
        return returnValue;
    }
}
