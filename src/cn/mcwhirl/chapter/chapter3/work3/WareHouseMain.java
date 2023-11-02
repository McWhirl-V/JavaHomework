package cn.mcwhirl.chapter.chapter3.work3;

public class WareHouseMain {
        public static void main(String[] args) throws InterruptedException {
            Warehouse warehouse = new Warehouse();
            warehouse.purchase("Item1", 60);
            warehouse.purchase("Item2", 60);
            warehouse.purchase("Item3", 60);

            // Starting multiple sales threads
            for (int i = 0; i < 5; i++) {  // Assuming 5 sales points
                new Thread(new SalesPoint(warehouse)).start();
            }

            Thread.sleep(10000);  // Let the system run for 10 seconds

            System.exit(0);  // Exit the system after 10 seconds
        }
}
