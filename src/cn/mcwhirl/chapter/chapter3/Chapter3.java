package cn.mcwhirl.chapter.chapter3;

import cn.mcwhirl.chapter.chapter3.work1.CustomerGoodsAdmin;
import cn.mcwhirl.chapter.chapter3.work2.PrimeCheckMain;
import cn.mcwhirl.chapter.chapter3.work3.StoreHouse;
import cn.mcwhirl.chapter.chapter3.work4.LeaderAchieve;
import cn.mcwhirl.chapter.chapter3.work4.Worker;
import cn.mcwhirl.chapter.chapter3.work5.StudentManager;
import cn.mcwhirl.utils.Tool;

public class Chapter3 {
    private Tool tool = new Tool();
    public void chapterMenu(){
        while(true){
            System.out.println(" ");
            System.out.println("------------------ 作业3 ------------------");
            System.out.println("请选择题目序号: 1 —— 客户选购信息管理系统；");
            System.out.println("请选择题目序号: 2 —— 素数的多线程判定；");
            System.out.println("请选择题目序号: 3 —— 仓库进货/出货系统；");
            System.out.println("请选择题目序号: 4 —— 回调；");
            System.out.println("请选择题目序号: 5 —— 学生信息的增删改查；0 —— 退出");
            System.out.println("-----------------------------------------");
            int option = tool.inputInt();
            switch (option) {
                case 1:
                    work1();
                    break;
                case 2:
                    work2();
                    break;
                case 3:
                    work3();
                    break;
                case 4:
                    work4();
                    break;
                case 5:
                    work5();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("无效的选项，请重新输入。");
        }
    }

}

    private void work1() {
        CustomerGoodsAdmin admin = new CustomerGoodsAdmin();
        admin.show();
    }

    private void work2() {
        PrimeCheckMain main = new PrimeCheckMain();
        main.start();
    }

    private void work3() {
        StoreHouse storeHouse = new StoreHouse();
        storeHouse.start();
    }

    private void work4() {
        Worker worker=new Worker("工人");
        char []chs={'A','B','C','D','E'};
        worker.start();
        for (int i = 0; i <5; i++) {
            LeaderAchieve leader=new LeaderAchieve("领导"+chs[i]);
            worker.leaders.add(leader);
            worker.receiveTask(worker.leaders.get(i),"任务"+chs[i]);
        }
    }

    private void work5() {
        StudentManager manager = new StudentManager();
        manager.showMenu();
    }
}
