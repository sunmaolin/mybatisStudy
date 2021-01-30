package 设计模式.day4观察者模式;

import java.util.Observable;
import java.util.Observer;

public class JingDongObserver implements Observer {
    public void update(Observable o, Object product) {
        System.out.println("发送新产品：" + product + "同步到京东商城");
    }
}
