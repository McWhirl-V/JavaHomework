package cn.mcwhirl.chapter.chapter3.work3;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Warehouse {
    private final Map<String, Integer> stock = new HashMap<>();

    public synchronized void purchase(String item, int amount) {
        stock.put(item, stock.getOrDefault(item, 0) + amount);
        System.out.println("Purchased " + amount + " of " + item + ". Current stock: " + stock.get(item));
        notifyAll();
    }

    public synchronized void sell(String item, int amount) throws InterruptedException {
        while (stock.getOrDefault(item, 0) < amount) {
            System.out.println("Waiting for stock of " + item);
            wait();
        }

        stock.put(item, stock.get(item) - amount);
        System.out.println("Sold " + amount + " of " + item + ". Current stock: " + stock.get(item));

        if (stock.get(item) < 20) {
            System.out.println(item + " stock is low. Requesting purchase...");
            // Notify corresponding purchase point to restock
            new Thread(() -> new PurchasePoint(item, this).restock()).start();
        }
    }
}

class PurchasePoint {
    private final String item;
    private final Warehouse warehouse;

    public PurchasePoint(String item, Warehouse warehouse) {
        this.item = item;
        this.warehouse = warehouse;
    }

    public void restock() {
        warehouse.purchase(item, 50);  // Purchase 50 units for simplicity
    }
}

class SalesPoint implements Runnable {
    private final Warehouse warehouse;
    private final Random random = new Random();

    public SalesPoint(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String item = "Item" + (random.nextInt(3) + 1);  // Assuming 3 types of items: Item1, Item2, Item3
                warehouse.sell(item, random.nextInt(10) + 1);  // Sell 1 to 10 units
                Thread.sleep(random.nextInt(200));  // Sleep for a random time up to 200ms
            }
        } catch (InterruptedException e) {
            System.out.println("SalesPoint interrupted");
        }
    }
}

