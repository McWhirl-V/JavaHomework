package cn.mcwhirl.chapter.chapter3.work1;

import cn.mcwhirl.utils.Tool;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class CustomerGoodsAdmin {
    private final List<Customer> customers = new ArrayList<>();
    private final List<Goods> goodsList = new ArrayList<>();
    private final Tool tool = new Tool();

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
                    printMenu();
                    break;
                case 0 :
                    return;
                default:
                    System.out.println("无效的选项，请重新输入。");

            }

        }
    }
    public void printMenu(){
        while(true){
            System.out.println("------------查询顾客购买信息-----------");
            System.out.println("1. 通过姓名查询信息 --> 1");
            System.out.println("2. 打印所有购买信息 --> 2");
            System.out.println("3. 返回 --> 0");
            System.out.println("-----------------------------------------");

            int option = tool.inputInt();
            switch (option){
                case 1:
                    searchByName();
                    break;
                case 2:
                    print();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("无效的选项，请重新输入。");
            }
        }
    }

    public void inputCustomerInfo() {
        while(true) {
            System.out.println("请输入客户姓名");
            String name = tool.inputString();

            int age = -1;
            while (age < 0) {
                System.out.println("请输入年龄");
                age = tool.inputInt();
                if(age < 0) {
                    System.out.println("年龄不能小于0，请重新输入。");
                }
            }

            while (true) {
                System.out.println("请输入购买的商品名");
                String gname = tool.inputString();

                int num = -1;
                while (num < 0) {
                    System.out.println("请输入购买数量");
                    num = tool.inputInt();
                    if(num < 0) {
                        System.out.println("购买数量不能小于0，请重新输入。");
                    }
                }

                double price = -1;
                while (price < 0) {
                    System.out.println("请输入单价");
                    price = tool.inputDouble();
                    if(price < 0) {
                        System.out.println("单价不能小于0，请重新输入。");
                    }
                }

                Goods goods = new Goods(gname, num, price);
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
    public void searchByName(){
        System.out.println("输入顾客姓名");
        String name = tool.inputString();
        List<Customer> results = customers.stream()
                .filter(customer -> customer.getName().equals(name))
                .toList();

        if (results.isEmpty()) {
            System.out.println("没有找到匹配的顾客。");
        } else {
            results.forEach(Customer::print);
        }
    }






}