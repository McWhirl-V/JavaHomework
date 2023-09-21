package cn.mcwhirl.Utils;

import java.util.Scanner;

public class Tool {
    private final Scanner reader = new Scanner(System.in);

    public int inputInt(){
        while(!reader.hasNextInt()){
            System.out.println("请输入整数");
            reader.nextLine();
        }
        return reader.nextInt();
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
}
