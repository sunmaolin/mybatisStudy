package 设计模式.day4观察者模式;

public class Client {
    public static void main(String[] args) {
        ProductList productList = ProductList.getInstance();
        productList.addProductListObserver(new JingDongObserver());
        productList.addProductListObserver(new TaoBaoObserver());

        productList.addProduct("草莓");

    }
}
