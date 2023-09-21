package cn.mcwhirl.chapter.chapter2;

import cn.mcwhirl.utils.Tool;
import cn.mcwhirl.chapter.chapter2.work1.MyPhone;
import cn.mcwhirl.chapter.chapter2.work2.Wrapper;
import cn.mcwhirl.chapter.chapter2.work3.Month;
import cn.mcwhirl.chapter.chapter2.work4.StudentManager;

public class Chapter2 {
    private Tool tool = new Tool();

    public void chapterMenu() {
        while (true) {
            System.out.println(" ");
            System.out.println("------------------ 作业2 ------------------");
            System.out.println("请选择题目序号: 1 —— 实现手机信息的录入，并打印输出结果；");
            System.out.println("请选择题目序号: 2 —— 利用包装类实现获取不同数据类型信息；");
            System.out.println("请选择题目序号: 3 —— 日历；");
            System.out.println("请选择题目序号: 4 —— 学生成绩管理系统；0 —— 退出");
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
        MyPhone phone = new MyPhone();
        phone.phoneData();
    }

    private void work2(){
        Wrapper wrapper = new Wrapper();
        wrapper.wrapperNum();
    }

    private void work3(){
        Month month = new Month();
        month.month();
    }

    private void work4(){
        StudentManager stu = new StudentManager();
        stu.gradeMenu();
    }
}
