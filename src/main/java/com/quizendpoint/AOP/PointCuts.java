package com.quizendpoint.AOP;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointCuts {

    @Pointcut("within(com.quizendpoint.controller.*)")
    public void inControllerLayer(){}

//    @Pointcut("bean(*Service)")
//    public void inService(){}
//
//    @Pointcut("execution(* com.quizendpoint.dao.*.*(..))")
//    public void inDAOLayer(){}
}
