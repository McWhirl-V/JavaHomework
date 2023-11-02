package cn.mcwhirl.chapter.chapter3.work2;

import cn.mcwhirl.utils.Tool;

import java.math.BigInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrimeCheckMain {
    private static final int THREAD_COUNT = 10;
    private static Tool tool = new Tool();

    public void start() {
        // Use a fixed thread pool to limit concurrency
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < THREAD_COUNT; i++) {
            System.out.println("请输入一个大于12位的整数：");
            String input;
            while (true) {
                input = tool.inputString();
                if (input.length() > 12 && input.matches("\\d+")) break;
                System.out.println("无效的输入，请重新输入一个大于12位的整数：");
            }
            BigInteger inputNumber = new BigInteger(input);
            executor.submit(new PrimeRunnable(inputNumber));
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
            // 等待所有进程结束
        }
        System.out.println("\n展示完毕，按回车键返回...");

        tool.inputString();  // 读取一行字符串，即按下回车键后返回
    }
}
