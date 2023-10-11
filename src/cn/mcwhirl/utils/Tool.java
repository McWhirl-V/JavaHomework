package cn.mcwhirl.utils;

import java.util.Scanner;

public class Tool {
    private final Scanner reader = new Scanner(System.in);

    public int inputInt(){
        while(!reader.hasNextInt()){
            System.out.println("请输入整数");
            reader.nextLine(); // 这一行会消耗掉不匹配的输入
        }
        int number = reader.nextInt();
        reader.nextLine(); // 增加这一行来消耗掉换行符
        return number;
    }
    public double inputDouble(){
        while(!reader.hasNextDouble()){
            System.out.println("请输入数字");
            reader.nextLine();
        }
        return reader.nextDouble();
    }

    public void close() {
        if (reader != null) {
            reader.close();
        }
    }

    public String inputString() {
        return reader.nextLine();
    }

}
