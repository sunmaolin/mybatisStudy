package 设计模式.day2动态代理拦截器;

import 设计模式.day1动态代理.HelloWorld;
import 设计模式.day1动态代理.HelloWorldImpl;

public class Client {
    public static void main(String[] args) {
        HelloWorld helloWorld = (HelloWorld)InterceptorJdkProxy.bind(new HelloWorldImpl(),"设计模式.day2动态代理拦截器.MyInterceptor");
        helloWorld.sayHelloWorld();
    }
}
