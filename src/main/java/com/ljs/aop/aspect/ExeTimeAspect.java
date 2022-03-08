package com.ljs.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

@Aspect
@Order(2)
public class ExeTimeAspect {
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
    public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        try {
            Object result = joinPoint.proceed();
            return result;
        } finally {
            long finish = System.nanoTime();
            Signature signature = joinPoint.getSignature();
            System.out.printf("%s.%s(%s) run time : %dns\n",
                    joinPoint.getTarget().getClass().getSimpleName(),
                    signature.getName(),
                    Arrays.toString(joinPoint.getArgs()),
                    (finish - start));
        }
    }
}