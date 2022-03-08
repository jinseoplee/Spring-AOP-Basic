package com.ljs.aop;

import com.ljs.aop.calculator.Calculator;
import com.ljs.aop.config.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAspect {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        Calculator calculator = ctx.getBean("calculator", Calculator.class);
        calculator.factorial(7);
        calculator.factorial(7);
        calculator.factorial(5);
        calculator.factorial(5);

        ctx.close();
    }

}