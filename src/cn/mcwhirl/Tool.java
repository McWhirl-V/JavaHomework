package cn.mcwhirl;

import java.util.Scanner;

public class Tool {
    Scanner reader = new Scanner(System.in);
    public int inputInt(){
        while(!reader.hasNextInt()){
            System.out.println("请输入整数");
            reader.nextLine();
        }
        int r = reader.nextInt();
        return r;
    }

    public double inputDouble(){
        while(!reader.hasNextDouble() || !reader.hasNextInt()){
            System.out.println("请输入数字");
            reader.nextLine();
        }
        double r = reader.nextDouble();
        return r;
    }

}
