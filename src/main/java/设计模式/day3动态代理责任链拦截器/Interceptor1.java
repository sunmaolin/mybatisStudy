package 设计模式.day3动态代理责任链拦截器;

import 设计模式.day2动态代理拦截器.Interceptor;

import java.lang.reflect.Method;

public class Interceptor1 implements Interceptor {
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.err.println("拦截器1的before方法");
        return true;
    }

    public void around(Object proxy, Object target, Method method, Object[] args) {

    }

    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.err.println("拦截器1的after方法");
    }
}
