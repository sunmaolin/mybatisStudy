package 设计模式.day2动态代理拦截器;

import java.lang.reflect.Method;

public class MyInterceptor implements Interceptor {
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.err.println("反射方法前逻辑");
        //不反射被代理对象原有方法
        return false;
    }

    public void around(Object proxy, Object target, Method method, Object[] args) {
        System.err.println("反射方法后逻辑");
    }

    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.err.println("取代了被代理对象的方法");

    }
}
