package 设计模式.day3动态代理责任链拦截器;

import 设计模式.day1动态代理.HelloWorld;
import 设计模式.day1动态代理.HelloWorldImpl;
import 设计模式.day2动态代理拦截器.InterceptorJdkProxy;

public class Client {
    public static void main(String[] args) {
        //创建第一个拦截器
        HelloWorld helloWorld1 = (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(),"设计模式.day3动态代理责任链拦截器.Interceptor1");
//        helloWorld1.sayHelloWorld();
        //在第一个拦截器基础上创建第二个拦截器
        HelloWorld helloWorld2 = (HelloWorld) InterceptorJdkProxy.bind(helloWorld1,"设计模式.day3动态代理责任链拦截器.Interceptor2");
//        helloWorld2.sayHelloWorld();
        //在第二个拦截器基础上创建第三个拦截器
        HelloWorld helloWorld3 = (HelloWorld) InterceptorJdkProxy.bind(helloWorld2,"设计模式.day3动态代理责任链拦截器.Interceptor3");
        helloWorld3.sayHelloWorld();
    }
}
