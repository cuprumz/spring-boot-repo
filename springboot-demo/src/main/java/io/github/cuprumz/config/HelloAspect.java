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

    public Object aroundMethod(ProceedingJoinPoint pjp) {
        Object result = null;
        String methodName = pjp.getSignature().getName();
        System.out.println("------c-u-p-r-u-m------  @Before  methodName = " + methodName);

        try {
            result = pjp.proceed();
            System.out.println("------c-u-p-r-u-m------  @AfterRunning  methodName = " + methodName);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("------c-u-p-r-u-m------  @AfterThrowing  methodName = " + methodName);
        }
        System.out.println("------c-u-p-r-u-m------  @after  methodName = " + methodName);

        return result;
    }
}
