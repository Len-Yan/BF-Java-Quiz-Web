package com.quizendpoint.AOP;

import com.quizendpoint.domain.*;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("com.quizendpoint.AOP.PointCuts.inControllerLayer()")
    public void logStartTime(){
        logger.info("From LoggingAspect.logStartTime in controller: " + System.currentTimeMillis());
    }

//    @After("com.quizendpoint.AOP.PointCuts.inService()")
//    public void logEndTime(JoinPoint joinPoint){
//        logger.info("From LoggingAspect.logEndTime in service: " + System.currentTimeMillis()  + ": " + joinPoint.getSignature());
//    }

//    @AfterReturning(value = "com.quizendpoint.AOP.PointCuts.inDAOLayer()", returning = "res")
//    public void logReturnObject(JoinPoint joinPoint, Object res){
//        logger.info("From LoggingAspect.logReturnObject in DAO: " + res + ": " + joinPoint.getSignature());
//    }
//
//    @AfterThrowing(value = "com.quizendpoint.AOP.PointCuts.inControllerLayer()", throwing = "ex")
//    public void logThrownException(JoinPoint joinPoint, Throwable ex){
//        logger.error("From LoggingAspect.logThrownException in controller: " + ex.getMessage() + ": " + joinPoint.getSignature());
//    }

    
    @Around("com.quizendpoint.AOP.PointCuts.inControllerLayer()")
    public Object logStartAndEndTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
    	Long startTime = System.currentTimeMillis();
    	
        Object q =  proceedingJoinPoint.proceed();
        
        Long endTime = System.currentTimeMillis();
        logger.info("This endpoint took " + (endTime - startTime) + " ms");

        return q;
    }
    
}
