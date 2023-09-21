package cn.mcwhirl.menus;

import cn.mcwhirl.utils.Tool;
import cn.mcwhirl.chapter.chapter1.Chapter1;
import cn.mcwhirl.chapter.chapter2.Chapter2;

public class Menu {
    private final Tool tool = new Tool();
    private final Chapter1 chapter1 = new Chapter1();
    private final Chapter2 chapter2 = new Chapter2();
    public void showMenu() {

        while (true) {
            // 简化菜单打印
            for (int i = 1; i <= 5; i++) {
                System.out.println("请选择作业号：" + i + "——作业" + i + "； 0——退出");
            }

            int option = tool.inputInt();
            switch (option) {
                case 1:
                    chapter1.chapterMenu();
                    break;
                case 2:
                    chapter2.chapterMenu();
                    break;
                case 3:
                    System.out.println("显示第3章的题目");
                    break;
                case 4:
                    System.out.println("显示第4章的题目");
                    break;
                case 5:
                    System.out.println("显示第5章的题目");
                    break;
                case 0:
                    tool.close();  // 关闭Tool实例
                    return;  // 退出方法
                default:
                    System.out.println("无效的选项，请重新输入。");
            }
        }
    }
}
