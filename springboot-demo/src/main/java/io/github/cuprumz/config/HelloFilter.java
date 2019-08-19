package io.github.cuprumz.config;


import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author cuprumz
 * @date 2019/08/19
 */
@Component
public class HelloFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("------c-u-p-r-u-m------  HelloFilter init()");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("------c-u-p-r-u-m------  HelloFilter start");
        long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("------c-u-p-r-u-m------  HelloFilter end");
        System.out.println("------c-u-p-r-u-m------  HelloFilter spend " + (System.currentTimeMillis() - start) + "ms");
    }

    @Override
    public void destroy() {
        System.out.println("------c-u-p-r-u-m------  HelloFilter destroy()");
    }
}
