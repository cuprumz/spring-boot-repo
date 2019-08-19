package io.github.cuprumz.config;

import org.springframework.core.MethodParameter;
import org.springframework.core.NamedThreadLocal;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author cuprumz
 * @date 2019/08/19
 */
@Component
public class HelloInterceptor extends HandlerInterceptorAdapter {

    private final NamedThreadLocal<Long> timeThreadLocal = new NamedThreadLocal<>("timeThreadLocal");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("------c-u-p-r-u-m------  HelloInterceptor preHandle()");

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        System.out.println("------c-u-p-r-u-m------  handlerMethod.getBeanType().getName() = " + handlerMethod.getBeanType().getName());
        System.out.println("------c-u-p-r-u-m------  handlerMethod.getMethod().getName() = " + handlerMethod.getMethod().getName());

        MethodParameter[] methodParameters = handlerMethod.getMethodParameters();
        for (MethodParameter param : methodParameters) {
            System.out.println("------c-u-p-r-u-m------  param.getParameterName() = " + param.getParameterName());
        }

        timeThreadLocal.set(System.currentTimeMillis());

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("------c-u-p-r-u-m------  HelloInterceptor postHandle()");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("------c-u-p-r-u-m------  HelloInterceptor afterCompletion()");

        System.out.println("------c-u-p-r-u-m------  HelloInterceptor spend " + (System.currentTimeMillis() - timeThreadLocal.get()) + "ms");
    }
}
