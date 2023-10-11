package cn.mcwhirl.chapter.chapter3;

import cn.mcwhirl.chapter.chapter3.work1.CustomerGoodsAdmin;
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
            System.out.println("请选择题目序号: 4 —— 回调；0 —— 退出");
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
    }

    private void work3() {
    }

    private void work4() {
    }
}
