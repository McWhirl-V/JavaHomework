package cn.mcwhirl.chapter.chapter2;

import cn.mcwhirl.Tool;

import java.util.Scanner;

public class MyPhone {
    private Scanner type = new Scanner(System.in);
    private Tool tool = new Tool();

    private String brand;
    private String OS;
    private int CPU;
    private double cost;

    public void phoneData() {
        System.out.println("请输入手机品牌");
        brand = type.next();

        System.out.println("请输入操作系统");
        type.useDelimiter("\n");
        OS = type.next();

        System.out.println("请输入CPU数量");
        CPU = tool.inputInt();

        System.out.println("请输入价格");
        cost = tool.inputDouble();

        System.out.println("手机品牌：" + brand);
        System.out.println("操作系统：" + OS);
        System.out.println("CPU数：" + CPU);
        System.out.println("价格：" + cost + "元");

        System.out.println("展示完毕，按任意键返回...");
        tool.inputInt();
    }

}
