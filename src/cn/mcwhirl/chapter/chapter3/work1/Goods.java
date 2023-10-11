package cn.mcwhirl.chapter.chapter3.work1;

public class Goods {
    private String name;
    private int num;
    private double price;
    private double totalPrice;

    public Goods(String name, int num, double price) {
        this.name = name;
        this.num = num;
        this.price = price;
        this.totalPrice = num * price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
        calculateTotalPrice();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        calculateTotalPrice();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    private void calculateTotalPrice() {
        this.totalPrice = num * price;
    }
}
