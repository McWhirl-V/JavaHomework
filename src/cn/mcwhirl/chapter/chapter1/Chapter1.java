package cn.mcwhirl.chapter.chapter1;

import cn.mcwhirl.Menu;
import cn.mcwhirl.Tool;

import java.util.Scanner;

public class Chapter1 {
    public void ChapterMenu(){
        while(true){
            System.out.println("请选择题目序号: 1——题目1； 2——题目2； 0——退出");
            Tool s = new Tool();
            int option = s.inputInt();
            if(option ==1){
                work1();
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
        System.out.println("------------------2022年9月------------------");
        System.out.println("一\t二\t三\t四\t五\t六\t日");
        System.out.println("\t\t\t1\t2\t3\t4");
        System.out.println("5\t6\t7\t8\t9\t10\t11");
        System.out.println("12\t13\t14\t15\t16\t17\t18");
        System.out.println("19\t20\t21\t22\t23\t24\t25");
        System.out.println("26\t27\t28\t29\t30");
    }

    private void work2(){
        System.out.println("人事管理系统");
        System.out.println("------------------");
        System.out.println("1、添加用户");
        System.out.println("2、查询用户");
        System.out.println("3、退出系统");
    }
}

