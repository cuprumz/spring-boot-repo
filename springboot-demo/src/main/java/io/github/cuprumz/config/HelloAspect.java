package io.github.cuprumz.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author cuprumz
 * @date 2019/08/19
 */
@Aspect
@Component
public class HelloAspect {

    @Around("execution(* io.github.cuprumz.web.*.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("------c-u-p-r-u-m------  HelloAspect handleControllerMethod() start");

        Object[] objs = pjp.getArgs();
        for (Object obj : objs) {
            System.out.println("------c-u-p-r-u-m------  obj = " + obj);
        }

        long start = System.currentTimeMillis();

        Object obj = pjp.proceed();

        System.out.println("------c-u-p-r-u-m------  HelloAspect handleControllerMethod() end");
        System.out.println("------c-u-p-r-u-m------  HelloAspect spend = " + (System.currentTimeMillis() - start) + "ms");

        return obj;
    }
}
