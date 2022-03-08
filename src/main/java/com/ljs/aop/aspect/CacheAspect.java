package com.ljs.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Order(1)
public class CacheAspect {

    private Map<Long, Object> cache = new HashMap<>();

    /*
     * set the target to apply the common function
     */
    @Pointcut("execution(public * com.ljs.aop.calculator..*(..))")
    public void commonTarget() {

    }

    /*
     * apply common function to pointcut
     */
    @Around("commonTarget()")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        Long num = (Long) joinPoint.getArgs()[0];
        if (cache.containsKey(num)) {
            System.out.printf("CacheAspect: get from cache[%d]\n", num);
            return cache.get(num);
        }

        Object result = joinPoint.proceed();
        cache.put(num, result);
        System.out.printf("CacheAspect: add to cache[%d]\n", num);
        return result;
    }

}
