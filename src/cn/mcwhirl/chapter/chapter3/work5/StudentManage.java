package cn.mcwhirl.chapter.chapter3.work5;

import cn.mcwhirl.utils.Tool;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManage {
    private static final int ADD_STUNDET=1;
    private static final int MODEFITY_STUNDET=2;
    private static final int DELETE_STUNDET=3;
    private static final int FIND_STUNDET=4;
    private static final int DOWNLOAD_STUDENT=5;
    private static final int EXIT=0;
    private Tool tool = new Tool();
    private static final FileAccess fileAccess=new FileAccess("D:/Java/StudentInfo.txt");;
    public void studentManage() throws IOException {
        ArrayList<StudentInfo> list=new ArrayList<>();
        while(true) {
            showMenu();
            int choice = tool.inputInt();
            if(choice==EXIT){
                System.out.println("欢迎下次使用！");
                break;
            }else if(choice==ADD_STUNDET){
                addStundet(list);
            }else if(choice==DELETE_STUNDET){
                deleteStundet(list);
            }else if(choice==FIND_STUNDET){
                findStundet(list);
            }else if(choice==MODEFITY_STUNDET){
                modefityStundet(list);
            }else if(choice==DOWNLOAD_STUDENT){
                FileAccess fileAccess1=new FileAccess("D:/Java/StudentInfo.txt");
                list=fileAccess1.readStudents(list);
                System.out.println("学生信息录入成功");
                printArr(list);
            }else{
                System.out.println("输入错误");
            }
        }
    }
    public void showMenu(){
        System.out.println("学生信息添加——————1");
        System.out.println("学生信息修改——————2");
        System.out.println("学生信息删除——————3");
        System.out.println("学生信息查询——————4");
        System.out.println("学生信息录入——————5");
        System.out.println("退出————0");
        System.out.print("请输入您的选择：");
    }
    public void addStundet(ArrayList<StudentInfo>list) throws IOException {
        System.out.print("请输入您要添加的学生的个数：");
        Scanner sc=new Scanner(System.in);
        int count=sc.nextInt();
        for (int i = 0; i < count; ) {
            System.out.print("请输入您要添加的第"+(i+1)+"个学生的学号：");
            String id=sc.next();
            System.out.print("请输入您要添加的第"+(i+1)+"个学生的姓名：");
            String name=sc.next();
            System.out.print("请输入您要添加的第"+(i+1)+"个学生的年龄：");
            int age=tool.inputInt();
            System.out.print("请输入您要添加的第"+(i+1)+"个学生的家庭住址：");
            String place=sc.next();
            System.out.print("请输入您要添加的第"+(i+1)+"个学生的学院：");
            String college=sc.next();
            System.out.print("请输入您要添加的第"+(i+1)+"个学生的专业：");
            String major=sc.next();
            System.out.print("请输入您要添加的第"+(i+1)+"个学生的班级：");
            String clas_s=sc.next();
            StudentInfo s=new StudentInfo(id,name,age,place,college,major,clas_s);
            if(getIdIndex(list,id)>=0){
                System.out.println("学号已存在，请重新输入");
            }else{
                list.add(s);
                i++;
            }
        }
        System.out.println("添加成功！信息如下:");
        printArr(list);
        fileAccess.saveStudents(list);
    }
    public void deleteStundet(ArrayList<StudentInfo>list) {
        System.out.print("请输入您要删除的学生的个数：");
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        for (int i = 0; i < count; ) {
            System.out.print("请输入您要删除的第" + (i + 1) + "个学生的学号：");
            String id = sc.next();
            if (getIdIndex(list, id) >= 0) {
                list.remove(getIdIndex(list, id));
                i++;
            } else {
                System.out.print("删除失败，请重新输入学生学号：");
            }
        }
        System.out.println("删除成功！删除后的学生信息如下：");
        printArr(list);
        fileAccess.saveStudents(list);
    }
    public void findStundet(ArrayList<StudentInfo>list){
        Scanner sc=new Scanner(System.in);
        System.out.print("请输入您要查找的学生姓名：");
        String name=sc.next();
        if(getNameIndex(list,name)>=0){
            System.out.println(list.get(getNameIndex(list,name)));
        }else{
            System.out.println("查无此人！");
        }
    }
    public void modefityStundet(ArrayList<StudentInfo>list){
        System.out.print("请输入您要修改的学生的个数：");
        Scanner sc = new Scanner(System.in);
        int count= sc.nextInt();
        for (int i = 0; i < count; ) {
            System.out.print("请输入您要修改的第"+(i+1)+"个学生的学号：");
            String id=sc.next();
            if(getIdIndex(list,id)>=0){
                System.out.print("请输入修改后的第"+(i+1)+"个学生的姓名：");
                String name=sc.next();
                list.get(getIdIndex(list,id)).setName(name);
                System.out.print("请输入修改后的第"+(i+1)+"个学生的年龄：");
                int age=sc.nextInt();
                list.get(getIdIndex(list,id)).setAge(age);
                System.out.print("请输入修改后的第"+(i+1)+"个学生的家庭住址：");
                String place=sc.next();
                list.get(getIdIndex(list,id)).setPlace(place);
                System.out.print("请输入修改后的第"+(i+1)+"个学生的学院：");
                String college=sc.next();
                list.get(getIdIndex(list,id)).setCollege(college);
                System.out.print("请输入修改后的第"+(i+1)+"个学生的专业：");
                String major=sc.next();
                list.get(getIdIndex(list,id)).setMajor(major);
                System.out.print("请输入修改后的第"+(i+1)+"个学生的班级：");
                String clas_s=sc.next();
                list.get(getIdIndex(list,id)).setClas_s(clas_s);
                i++;
            }else{
                System.out.print("修改失败，请重新输入学生学号：");
            }
        }
        System.out.println("修改成功！修改后的学生信息如下：");
        printArr(list);
        fileAccess.saveStudents(list);
    }
    public void printArr(ArrayList<StudentInfo>list){
        if(list!=null&&!list.isEmpty()){
            for(StudentInfo studentInfo:list){
                System.out.println(studentInfo);
            }
        }
    }
    public int getIdIndex(ArrayList<StudentInfo>list,String id){
        if(list!=null&&!list.isEmpty()){
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i)!=null){
                    if(list.get(i).getId().equals(id)){
                        return i;
                    }
                }
            }
        }
        return -1;
    }
    public int getNameIndex(ArrayList<StudentInfo> list, String name){
        if(list!=null&&!list.isEmpty()){
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i)!=null){
                    if(list.get(i).getName().equals(name)){
                        return i;
                    }
                }
            }
            return -1;
        }else{
            return -1;
        }
    }
}
