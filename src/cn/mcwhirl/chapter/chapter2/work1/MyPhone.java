package cn.mcwhirl.chapter.chapter2.work1;

import cn.mcwhirl.utils.Tool;

import java.util.Scanner;

public class MyPhone {
    private final Scanner type = new Scanner(System.in);
    private final Tool tool = new Tool();

    public void phoneData() {
        System.out.println("请输入手机品牌");
        String brand = type.next();

        System.out.println("请输入操作系统");
        type.useDelimiter("\n");
        String OS = type.next();

        System.out.println("请输入CPU数量");
        int CPU = tool.inputInt();

        System.out.println("请输入价格");
        double cost = tool.inputDouble();

        System.out.println("手机品牌：" + brand);
        System.out.println("操作系统：" + OS);
        System.out.println("CPU数：" + CPU);
        System.out.println("价格：" + cost + "元");

        System.out.println("\n展示完毕，按回车键返回...");

        tool.inputString();  // 读取一行字符串，即按下回车键后返回
    }

}
