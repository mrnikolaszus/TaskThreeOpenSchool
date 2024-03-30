package com.nickz.aopdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Logging functionality for service layer methods using AOP.
 */
@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    /**
     * Defines a pointcut for executing methods in the service layer.
     */
    @Pointcut("execution(* com.nickz.aopdemo.service.*.*(..))")
    public void serviceLayerExecution() {}

    /**
     * Logs method invocation before its execution.
     * @param joinPoint the join point containing information about the method being called and its arguments
     */
    @Before("serviceLayerExecution()")
    public void logBeforeMethod(JoinPoint joinPoint) {
        logger.warn("Before method: " + joinPoint.getSignature().getName() + ", Arguments: " + java.util.Arrays.toString(joinPoint.getArgs()));
    }

    /**
     * Logs method return value after its execution.
     * @param joinPoint the join point containing information about the method being called and its return value
     * @param result the return value of the method
     */
    @AfterReturning(pointcut = "serviceLayerExecution()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.warn("After returning from method: " + joinPoint.getSignature().getName() + ", Result: " + result);
    }

    /**
     * Logs exceptions thrown during method execution.
     * @param joinPoint the join point containing information about the method being called and the thrown exception
     * @param ex the exception thrown by the method
     */
    @AfterThrowing(pointcut = "serviceLayerExecution()", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable ex) {
        logger.warn("After throwing in method: " + joinPoint.getSignature().getName() + ", Exception: " + ex.getMessage());
    }

    /**
     * Logs method completion after its execution.
     * @param joinPoint the join point containing information about the method being called
     */
    @After("serviceLayerExecution()")
    public void logAfterMethod(JoinPoint joinPoint) {
        logger.warn("After method: " + joinPoint.getSignature().getName());
    }
}