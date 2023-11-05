package cn.mcwhirl.chapter.chapter3.work3;

import cn.mcwhirl.chapter.chapter3.Chapter3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class StoreHouse {

    boolean a = true;
    boolean b = false;
    private static final int NUM_PRODUCTS = 3;
    private static final int NUM_SALES_POINTS = 5;
    private static final int NUM_PURCHASE_POINTS = 2;

    private int[] stock;
    private Object[] productLocks;
    private ExecutorService salesExecutor;
    private ExecutorService purchaseExecutor;

    public StoreHouse() {
        stock = new int[NUM_PRODUCTS];
        productLocks = new Object[NUM_PRODUCTS];
        for (int i = 0; i < NUM_PRODUCTS; i++) {
            stock[i] = 100; // 初始化货物数量为100
            productLocks[i] = new Object();
        }
        salesExecutor = Executors.newFixedThreadPool(NUM_SALES_POINTS);
        purchaseExecutor = Executors.newFixedThreadPool(NUM_PURCHASE_POINTS);
    }

    public void start() {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        // 安排一个任务，在10秒后关闭销售点和进货点并跳转至 Chapter3

        scheduler.schedule(() -> {
            a = b = false;
            Chapter3 chapter3 = new Chapter3();
            chapter3.chapterMenu();
        }, 10, TimeUnit.SECONDS);

        salesExecutor.execute(this::simulateSales);
        for (int i = 0; i <= NUM_PURCHASE_POINTS; i++) {
            final int productIndex = i;
            purchaseExecutor.execute(() -> simulatePurchase(productIndex));
        }
    }


    private void simulateSales() {
        while (a) { // 检查线程池是否已关闭
            for (int i = 0; i < NUM_PRODUCTS; i++) {
                int quantitySold = (int) (Math.random() * 4) + 1;
                int productIndex = i;
                synchronized (productLocks[productIndex]) {
                    if (stock[productIndex] - quantitySold < 20 && !b) {
                        System.out.println("货物 " + productIndex + " 库存不足，启动进货线程。");
                        b = true; // 设置标志以避免重复启动进货线程
                        purchaseExecutor.execute(() -> simulatePurchase(productIndex));
                    }
                    stock[productIndex] -= quantitySold;
                    System.out.println("销售点: 货物 " + productIndex + " 售出 " + quantitySold + " 单位。剩余库存: " + stock[productIndex]);
                }
            }
            try {
                Thread.sleep((int) (Math.random() * 500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void simulatePurchase(int productIndex) {
        while (b) {
            synchronized (productLocks[productIndex]) {
                int quantityPurchased = (int) (Math.random() * 10) + 1; // 假设每次进货数量是1到10之间的随机数
                stock[productIndex] += quantityPurchased;
                System.out.println("进货点: 货物 " + productIndex + " 进货 " + quantityPurchased + " 单位。当前库存: " + stock[productIndex]);
            }

            try {
                Thread.sleep((int) (Math.random() * 1000) + 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}