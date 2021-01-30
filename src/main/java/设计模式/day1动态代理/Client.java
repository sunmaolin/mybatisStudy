package 设计模式.day1动态代理;

public class Client {
    public static void main(String[] args) {
        JdkProxyExample jdkProxyExample = new JdkProxyExample();
        //绑定关系
        HelloWorld helloWorldProxy = (HelloWorld) jdkProxyExample.bind(new HelloWorldImpl());
        //此时已经是一个代理对象
        helloWorldProxy.sayHelloWorld();
    }
}
