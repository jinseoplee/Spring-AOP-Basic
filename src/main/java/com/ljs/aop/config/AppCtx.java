package com.ljs.aop.config;

import com.ljs.aop.aspect.CacheAspect;
import com.ljs.aop.aspect.ExeTimeAspect;
import com.ljs.aop.calculator.Calculator;
import com.ljs.aop.calculator.RecCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppCtx {
    @Bean
    public ExeTimeAspect exeTimeAspect() {
        return new ExeTimeAspect();
    }

    @Bean
    public CacheAspect cacheAspect() {
        return new CacheAspect();
    }

    @Bean
    public Calculator calculator() {
        return new RecCalculator();
    }
}
