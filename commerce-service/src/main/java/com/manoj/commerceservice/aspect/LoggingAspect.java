package com.manoj.commerceservice.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * <a href="https://docs.spring.io/spring-framework/docs/2.5.5/reference/aop.html">Spring AOP Doc</a>
 * @author manoj.suthar
 */
@Component
@Aspect
@Slf4j
public class LoggingAspect {

    /*execution(modifiers-pattern? ret-type-pattern declaring-type-pattern? name-pattern(param-pattern)
            throws-pattern?)*/

    //@Pointcut using execution()
    @Pointcut("execution(* com.manoj.commerceservice.service.impl.CommerceServiceImpl.getAllProducts(..))")
    public void beforeMethodInvokeLog() {}

    //@Pointcut using within()
    @Pointcut("within(com.manoj.commerceservice.service..*)")
    public void inServiceLayerAfter() {}

    //@Pointcut using @annotation()
    @Pointcut("@annotation(DisplayParameter)")
    public void displayParameter(){}

    //Direct access to pointcut
    @Before("beforeMethodInvokeLog()")
    public void beforeEachMethod() {
        //log.info("Aspect: @Before called");
    }
    //or
    //Separate access to pointcut
    @Before("com.manoj.commerceservice.aspect.PointcutArchitecture.inServiceLayerBefore()")
    public void inServiceBefore() {
        //log.info("Aspect: In Service Layer Before");
    }

    //Executed after each function in service layer
    @After("inServiceLayerAfter()")
    public void afterEachMethod() {
        //log.info("Aspect: @After called");
    }

    //Getting return value from each function after execution
    @AfterReturning(pointcut = "inServiceLayerAfter()", returning = "returnValue")
    public void doAccessCheck(Object returnValue) {
        //log.info(returnValue.toString());
    }

    //Getting exception after while function execution
    @AfterThrowing(pointcut = "inServiceLayerAfter()", throwing = "ex")
    public void doRecoveryActions(Exception ex) {
        //log.info(ex.getMessage());
    }

    //@annotation based pointcut which displays parameters
    @Before("displayParameter()")
    public void displayParameterBefore(JoinPoint joinPoint){
        //log.info("Function: "+joinPoint.getSignature().getName());
        //log.info("Parameter(s): "+ Arrays.toString(Arrays.stream(joinPoint.getArgs()).toArray()));
        //log.info("Source: "+joinPoint.getSourceLocation().toString());
    }

    //@annotation based pointcut which displays parameters
    @AfterReturning(pointcut = "com.manoj.commerceservice.aspect.PointcutArchitecture.logReturnValuePointcut()", returning = "returnValue")
    public void logReturnValues(Object returnValue){
        log.info("Return values: "+returnValue.toString());
    }
}
