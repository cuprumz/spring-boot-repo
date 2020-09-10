package io.github.cuprumz.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {

    @Test
    public void test() {
        InvocationHandler handler = new InvocationHandler() {
            Object obj = new HelloImpl();

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                System.out.println(proxy);
                System.out.println(method);
                System.out.println(args);
                String methodName = method.getName();
                if ("morning".equals(methodName)) {
                    System.out.println(methodName + "()方法开始时间：" + System.currentTimeMillis());
                    method.invoke(obj, args); // obj.method(args)
                    System.out.println(methodName + "()方法结束时间：" + System.currentTimeMillis());
                    return obj;
                }
                method.invoke(obj, args); // obj.method(args)
                return obj;
            }
        };
        Hello hello = (Hello) Proxy.newProxyInstance(Hello.class.getClassLoader(), new Class[]{Hello.class}, handler);
        hello.morning("yourname");
        hello.night("yourname");
    }

    @Test
    public void test1() {
        MethodInterceptor methodInterceptor = new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                String methodName = method.getName();
                if ("morning".equals(methodName)) {
                    System.out.println(methodName + "()方法开始时间：" + System.currentTimeMillis());
                    methodProxy.invokeSuper(o, objects);
                    System.out.println(methodName + "()方法结束时间：" + System.currentTimeMillis());
                    return o;
                }
                methodProxy.invokeSuper(o, objects);
                return o;
            }
        };

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloImpl.class);
        enhancer.setCallback(methodInterceptor);

        Hello hello = (Hello) enhancer.create();
        hello.morning("cglib");
        hello.night("cglib");
    }

}

interface Hello {
    void morning(String name);

    void night(String name);
}

class HelloImpl implements Hello {

    @Override
    public void morning(String name) {
        // TODO Auto-generated method stub
        System.out.println("hello, " + name + "!");
    }

    @Override
    public void night(String name) {
        System.out.println("night, " + name);
    }

}