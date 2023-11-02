package cn.mcwhirl.chapter.chapter3.work4;

import java.util.ArrayList;

public class Worker extends Thread {
    private String name;
    public ArrayList<LeaderAchieve> leaders;

    public Worker() {
    }

    public Worker(String name) {
        this.name = name;
        this.leaders = new ArrayList<>();
    }


    public String getWorkerName() {
        return name;
    }


    public void setWorkerName(String name) {
        this.name = name;
    }

    public void receiveTask(LeaderAchieve leader, String task) {
        System.out.println(name + "接收" + leader.getName() + "分配的" + task);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        leader.callback(name, task + "已完成");
    }

    @Override
    public void run() {
        System.out.println(name + "正在做其他任务");
    }
}
