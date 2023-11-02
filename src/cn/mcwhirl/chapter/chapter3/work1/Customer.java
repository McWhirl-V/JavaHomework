package cn.mcwhirl.chapter.chapter3.work1;

import java.util.Arrays;
import java.util.List;

public class Customer {
    private String name;
    private int age;
    private Goods[] goods;
    private double total;

    public Customer(String name, int age, List<Goods> goods) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("名字不能为空");
        }
        if (age <= 0) {
            throw new IllegalArgumentException("请输入正确的年龄");
        }
        if (goods == null || goods.isEmpty()) {
            throw new IllegalArgumentException("商品不能为空");
        }
        this.name = name;
        this.age = age;
        this.goods = goods.toArray(new Goods[0]);
        calculateTotal();
    }

    public String getName(){
        return name;
    }
    private void calculateTotal() {
        total = Arrays.stream(goods).mapToDouble(g -> g.getTotalPrice()).sum();
    }

    public void print() {
        System.out.println("---------------------------------------------------------");
        System.out.println("姓名：" + name + "；年龄：" + age);
        System.out.println("---------------------------------------------------------");
        for (Goods g : goods) {
            System.out.println(g.getName() + "；单价：" + g.getPrice() + "； 购买数量：" + g.getNum() + "； 总计：" + g.getTotalPrice());
        }
        System.out.println("总计：" + total);
    }

    // 在Customer类中
    public double getTotal() {
        return total;
    }


}