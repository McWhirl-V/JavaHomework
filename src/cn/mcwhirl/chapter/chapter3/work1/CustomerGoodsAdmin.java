package cn.mcwhirl.chapter.chapter3.work1;

import cn.mcwhirl.chapter.chapter3.Chapter3;
import cn.mcwhirl.utils.Tool;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerGoodsAdmin {
    private List<Customer> customers = new ArrayList<>();
    private List<Goods> goodsList = new ArrayList<>();
    private final Tool tool = new Tool();

    private Scanner reader = new Scanner(System.in);

    public void show() {
        while(true){
            System.out.println("-----------------------------------------");
            System.out.println("1. 顾客购买录入 --> 1");
            System.out.println("2. 查询顾客购买信息 --> 2");
            System.out.println("3. 退出 --> 0");
            System.out.println("-----------------------------------------");
            int option = tool.inputInt();
            switch (option){
                case 1:
                    inputCustomerInfo();
                    break;
                case 2 :
                    print();
                    break;
                case 0 :
                    return;

            }

        }
    }

    public void inputCustomerInfo() {
        /*
        /外部while循环
         */
        while(true) {
            System.out.println("请输入客户姓名");
            String name = reader.next();

            System.out.println("请输入年龄");
            int age = tool.inputInt();

            Goods goods;
            while (true) {
                System.out.println("请输入购买的商品名");
                String gname = reader.next();

                System.out.println("请输入购买数量");
                int num = tool.inputInt();

                System.out.println("请输入单价");
                double price = tool.inputDouble();

                goods = new Goods(gname, num, price);
                goodsList.add(goods);

                System.out.println("商品已添加。");
                System.out.println("是否要继续添加商品信息? 输入1继续，其他数字退出。");
                int choice = tool.inputInt();

                if (choice != 1) {
                    break;
                }
            }

            Customer customer = new Customer(name, age, goodsList);
            customers.add(customer);

            System.out.println("该顾客已添加");
            System.out.println("是否要继续添加其他顾客? 输入1继续，其他数字退出。");

            int choice = tool.inputInt();
            if (choice != 1) {
                break;
            }
        }
    }

    public void print() {
        customers.forEach(Customer::print);
    }


}
