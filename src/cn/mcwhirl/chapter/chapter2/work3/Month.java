package cn.mcwhirl.chapter.chapter2.work3;

import cn.mcwhirl.utils.Tool;

import java.util.Calendar;

public class Month {

    private final Tool tool = new Tool();

    public void month() {
        int year;
        do {
            System.out.print("请输入年份: ");
            year = tool.inputInt();
        } while (year <= 0);

        int month;
        do {
            System.out.print("请输入月份 (1-12): ");
            month = tool.inputInt() - 1;
        } while (month < 0 || month > 11);

        printMonthCalendar(year, month);

        System.out.println("\n展示完毕，按回车键返回...");

        tool.inputString();  // 读取一行字符串，即按下回车键后返回
    }

    private void printMonthCalendar(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, 1);

        int firstDayOfWeek = (calendar.get(Calendar.DAY_OF_WEEK) + 5) % 7;  // 修改了这里的计算
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        System.out.println("一\t二\t三\t四\t五\t六\t日");

        for (int i = 0; i < firstDayOfWeek; i++) {
            System.out.print("\t");
        }

        for (int day = 1; day <= daysInMonth; day++) {
            System.out.print(day + "\t");
            if ((day + firstDayOfWeek) % 7 == 0) {
                System.out.println();
            }
        }
    }
}
