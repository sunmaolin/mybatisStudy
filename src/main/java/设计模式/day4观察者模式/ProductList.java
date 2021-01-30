package 设计模式.day4观察者模式;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * 被观察者产品列表
 */
public class ProductList extends Observable {

    //产品列表
    private static List<String> productList = null;

    //被观察者，类唯一实例
    private static ProductList instance = null;

    //私有化构造器
    private ProductList() {
    }

    public static ProductList getInstance() {
        if (instance == null) {
            synchronized (ProductList.class) {
                if (instance == null) {
                    instance = new ProductList();
                    productList = new ArrayList();
                }
            }
        }
        return instance;
    }

    /**
     * 添加观察者对象
     *
     * @param observer
     */
    public void addProductListObserver(Observer observer) {
        this.addObserver(observer);
    }

    /**
     * 添加产品
     *
     * @param product
     */
    public void addProduct(String product) {
        productList.add(product);
        System.out.println("产品列表新增了产品：" + product);
        this.setChanged();
        this.notifyObservers(product);
    }
}
