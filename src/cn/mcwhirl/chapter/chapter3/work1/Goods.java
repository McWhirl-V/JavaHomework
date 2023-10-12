package cn.mcwhirl.chapter.chapter3.work1;

public class Goods {
    private String name;
    private int num;
    private double price;
    private double totalPrice;

    public Goods(String name, int num, double price) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("商品名不能为空");
        }
        if (num <= 0) {
            throw new IllegalArgumentException("请输入正确商品数量");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("请输入正确的价格");
        }
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