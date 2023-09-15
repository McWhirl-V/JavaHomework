package cn.mcwhirl.chapter.chapter2;

import cn.mcwhirl.Tool;

import java.util.Calendar;
import java.util.Scanner;

public class Month {

    private Tool tool = new Tool();

    public void month() {
        // 输入年份日期
        System.out.print("请输入年份: ");
        int year = tool.inputInt();
        System.out.print("请输入月份 (1-12): ");
        int month = tool.inputInt() - 1;

        if (month < 0 || month > 11) {
            System.out.println("输入的月份不正确。");
            return;
        }

        printMonthCalendar(year, month);

        System.out.println("\n展示完毕，输入任意键返回...");
        tool.inputInt();
    }

    private void printMonthCalendar(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, 1);

        int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1; // 这里的 -1 是为了使星期一对应0
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        System.out.println("一\t二\t三\t四\t五\t六\t日"); // 将周日移动到最后

        // 如果月份的第一天不是周一，就要打印一些空格
        for (int i = 0; i < firstDayOfWeek; i++) {
            System.out.print("\t");
        }

        // 打印月份的每一天
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.print(day + "\t");
            if ((day + firstDayOfWeek) % 7 == 0) { // 当我们到达行尾时进行换行
                System.out.println();
            }
        }
    }
}
