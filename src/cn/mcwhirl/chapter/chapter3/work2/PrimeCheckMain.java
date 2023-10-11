package cn.mcwhirl.chapter.chapter3.work2;

import cn.mcwhirl.utils.Tool;

import java.math.BigInteger;

public class PrimeCheckMain {
    private static final int THREAD_COUNT = 10;
    private static Tool tool = new Tool();

    public static void main(String args[]){
        for (int i = 0; i < THREAD_COUNT; i++) {
            System.out.println("请输入一个大于12位的整数：");
            String input = tool.inputString(); // Ensure this input is valid and large
            BigInteger inputNumber = new BigInteger(input);
            Thread thread = new Thread(new PrimeRunnable(inputNumber));
            thread.start();
        }
        System.out.println("展示完毕，输入任意键返回...");
        tool.inputInt();

    }


}
