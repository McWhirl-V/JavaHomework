package cn.mcwhirl.chapter.chapter2;

import cn.mcwhirl.Menu;
import cn.mcwhirl.Tool;

public class Chapter2 {
    public void ChapterMenu(){
        while(true){

            System.out.println("------------------ 作业2 ------------------");
            System.out.println("请选择题目序号: 1——累加器； 2——实现手机信息的录入，并打印输出结果");
            System.out.println("请选择题目序号: 3——作业3； 4——作业4；");
            System.out.println("请选择题目序号: 5——作业5（猜拳游戏）； 6——作业6（日历）；");
            System.out.println("请选择题目序号: 7——作业7（学生成绩管理系统）；0——退出");
            System.out.println("-----------------------------------------");

            Tool s = new Tool();
            int option = s.inputInt();
            if(option ==1){

            }else if(option ==2){
                work2();

            }else if(option ==0){
                Menu menu = new Menu();
                menu.showMenu();
                break;
            }
        }
    }

    private void work1(){

    }

    private void work2(){
        MyPhone phone = new MyPhone();
        phone.PhoneData();

    }

    private void work3(){

    }

    private void work4(){

    }

    private void work5(){

    }

    private void work6(){

    }

    private void work7(){

    }
}
