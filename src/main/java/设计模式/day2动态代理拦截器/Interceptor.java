package 设计模式.day2动态代理拦截器;

import java.lang.reflect.Method;

/**
 * 定义拦截器接口
 */
public interface Interceptor {
    /**
     *真实对象前调用，当返回true时，则反射真实对象的方法；返回会false时，则调用around方法
     */
    public boolean before(Object proxy, Object target, Method method, Object[] args);

    public void around(Object proxy, Object target, Method method, Object[] args);

    public void after(Object proxy, Object target, Method method, Object[] args);


}
