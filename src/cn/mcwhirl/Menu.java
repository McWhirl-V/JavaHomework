package cn.mcwhirl;

import cn.mcwhirl.chapter.chapter1.Chapter1;
import cn.mcwhirl.chapter.chapter2.Chapter2;

public class Menu {
    public void showMenu()
    {
        while(true){
            System.out.println("请选择作业号：1——作业1； 0——退出");
            System.out.println("请选择作业号：2——作业2； 0——退出");
            System.out.println("请选择作业号：3——作业3； 0——退出");
            System.out.println("请选择作业号：4——作业4； 0——退出");
            System.out.println("请选择作业号：5——作业5； 0——退出");
            Tool s = new Tool();
            int option = s.inputInt();
            if(option ==1){
                Chapter1 chapter = new Chapter1();
                chapter.ChapterMenu();
            }else if(option ==2){
                Chapter2 chapter = new Chapter2();
                chapter.ChapterMenu();
            }else if(option ==3){
                System.out.println("显示第3章的题目");
            }else if(option ==4){
                System.out.println("显示第4章的题目");
            }else if(option ==5){
                System.out.println("显示第5章的题目");
            }else if(option ==0){
                break;
            }
        }
    }

}