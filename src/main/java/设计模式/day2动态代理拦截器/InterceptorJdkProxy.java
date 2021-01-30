package 设计模式.day2动态代理拦截器;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InterceptorJdkProxy implements InvocationHandler {

    private Object target;
    private String interceptorClass;

    /**
     * @param target 真实对象
     * @param interceptorClass 定义的拦截器名
     */
    public InterceptorJdkProxy(Object target, String interceptorClass) {
        this.target = target;
        this.interceptorClass = interceptorClass;
    }

    /**
     * 绑定真实对象
     * @param target
     * @param interceptorClass
     * @return
     */
    public static Object bind(Object target,String interceptorClass){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),
                new InterceptorJdkProxy(target,interceptorClass));
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //当代理对象调用方法时，走该方法

        //未定义拦截器，直接真实对象调用方法返回
        if(interceptorClass == null){
            return method.invoke(target,args);
        }

        Object result = null;
        //通过反射生成拦截器
        Interceptor interceptor = (Interceptor) Class.forName(interceptorClass).newInstance();

        //调用前置方法before
        if(interceptor.before(proxy,target,method,args)){
            //如果true,则反射原有对象方法
            result = method.invoke(target,args);
        }else{
            //调用拦截器方法
            interceptor.around(proxy,target,method,args);
        }
        //最后调用after方法
        interceptor.after(proxy,target,method,args);

        return result;
    }
}
