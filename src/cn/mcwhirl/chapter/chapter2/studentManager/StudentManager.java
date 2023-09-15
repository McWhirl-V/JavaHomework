package cn.mcwhirl.chapter.chapter2.studentManager;

import cn.mcwhirl.Tool;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StudentManager {
    private Tool tool = new Tool();
    private Scanner reader = new Scanner(System.in);
    private List<Student> students = new ArrayList<>();

    public void gradeMenu(){
        while(true) {
            System.out.println("-----学生信息管理系统-----");
            System.out.println("1---成绩录入");
            System.out.println("2---学生成绩打印");
            System.out.println("3---打印总成绩");
            System.out.println("0---退出");

            int choice = tool.inputInt();
            switch (choice) {
                case 1:
                    enterGrades();
                    break;
                case 2:
                    printGrades();
                    break;
                case 3:
                    printTotalGrades();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("无效的选项，请重新输入。");
            }
        }
    }

    public void sortAndPrintStudents() {
        while (true) {
            System.out.println("选择排序方式：1——升序；2——降序；3——退出");
            int choice = tool.inputInt();
            List<Student> sortedStudents;

            switch (choice) {
                case 1:
                    sortedStudents = students.stream().sorted(Comparator.comparingDouble(Student::getAverageGrade)).collect(Collectors.toList());
                    break;
                case 2:
                    sortedStudents = students.stream().sorted(Comparator.comparingDouble(Student::getAverageGrade).reversed()).collect(Collectors.toList());
                    break;
                case 3:
                    return;
                default:
                    System.out.println("无效的选项，请重新输入。");
                    continue;
            }

            printFormattedGrades(sortedStudents);
        }
    }

    private void printFormattedGrades(List<Student> studentsList) {
        System.out.println("姓名\tjava\t\thtml\t\tsql\t\t总分\t\t平均分");
        for (Student student : studentsList) {
            System.out.printf("%s\t%.2f\t\t%.2f\t\t%.2f\t\t%.2f\t\t%.2f%n",
                    student.getName(), student.getJavaGrade(), student.getHtmlGrade(),
                    student.getSqlGrade(), student.getTotalGrade(), student.getAverageGrade());
        }
    }

    private void enterGrades() {
        while (true) {
            System.out.println("请输入学生姓名:");
            String name = reader.next();

            System.out.println("请输入" + name + "的java成绩:");
            double javaGrade = reader.nextDouble();

            System.out.println("请输入" + name + "的html成绩:");
            double htmlGrade = reader.nextDouble();

            System.out.println("请输入" + name + "的sql成绩:");
            double sqlGrade = reader.nextDouble();

            // 创建一个新的学生对象并添加到students列表中
            Student newStudent = new Student(name, javaGrade, htmlGrade, sqlGrade);
            students.add(newStudent);

            System.out.println("学生信息已添加。");
            System.out.println("是否要继续添加学生信息? 输入1继续，其他数字退出。");
            int choice = tool.inputInt();

            if (choice != 1) {
                break;
            }
        }
    }
    private void printGrades() {
        while (true) {
            System.out.println("选择操作:");
            System.out.println("1. 打印所有学生成绩");
            System.out.println("2. 排序并打印学生成绩");
            System.out.println("3. 返回");

            int choice = tool.inputInt();

            switch (choice) {
                case 1:
                    printFormattedGrades(students);  // 打印所有学生成绩，无排序
                    break;
                case 2:
                    sortAndPrintStudents();  // 打印排序后的学生成绩
                    break;
                case 3:
                    return;  // 返回上一级菜单
                default:
                    System.out.println("无效的选项，请重新选择。");
            }
        }
    }
    private void printTotalGrades() {
        double totalJavaGrade = 0;
        double totalHtmlGrade = 0;
        double totalSqlGrade = 0;

        for (Student student : students) {
            totalJavaGrade += student.getJavaGrade();
            totalHtmlGrade += student.getHtmlGrade();
            totalSqlGrade += student.getSqlGrade();
        }

        System.out.println("Java总分: " + totalJavaGrade);
        System.out.println("HTML总分: " + totalHtmlGrade);
        System.out.println("SQL总分: " + totalSqlGrade);
    }

}
