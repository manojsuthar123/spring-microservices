package com.manoj.commerceservice.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public final class PointcutArchitecture {

    @Pointcut("within(com.manoj.commerceservice.service..*)")
    public void inServiceLayerBefore() {}

    @Pointcut("@annotation(LogReturnValue)")
    public void logReturnValuePointcut() {}
}
