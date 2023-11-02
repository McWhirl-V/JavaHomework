package cn.mcwhirl.chapter.chapter3.work5;

import java.util.*;
import java.io.*;

public class StudentManager {
    private Map<String, Student> students = new HashMap<>();

    // 从文件中加载学生信息
    public void loadFromFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 2) {
                Student student = new Student(parts[0], parts[1]);
                students.put(student.getId(), student);
            }
        }
        reader.close();
    }

    // 将学生信息保存到文件中
    public void saveToFile(String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (Student student : students.values()) {
            writer.write("编号: "+student.getId() + " , 姓名: " + student.getName());
            writer.newLine();
        }
        writer.close();
    }

    // 增加学生对象
    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }

    // 修改学生信息
    public void updateStudent(String id, Student newInfo) {
        students.put(id, newInfo);
    }

    // 删除学生信息
    public void deleteStudent(String id) {
        students.remove(id);
    }

    // 查询学生信息
    public List<Student> searchStudents(String keyword) {
        List<Student> result = new ArrayList<>();
        for (Student student : students.values()) {
            if (student.getName().contains(keyword) || student.getId().contains(keyword)) {
                result.add(student);
            }
        }
        return result;
    }

    public void showMenu(){
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        String filename = "E:\\Idea\\JavaChapter\\src\\cn\\mcwhirl\\chapter\\chapter3\\work5\\students.txt"; // 假设文件名为students.txt

        try {
            manager.loadFromFile(filename);
        } catch (IOException e) {
            System.out.println("加载文件失败。");
        }

        while (true) {
            System.out.println("学生信息管理");
            System.out.println("-------------------------------");
            System.out.println("学生信息添加——1");
            System.out.println("学生信息修改——2");
            System.out.println("学生信息删除——3");
            System.out.println("学生信息查询——4");
            System.out.println("退出——0");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("请输入学生编号：");
                    String id = scanner.nextLine();
                    System.out.println("请输入学生姓名：");
                    String name = scanner.nextLine();
                    manager.addStudent(new Student(id, name));
                    break;
                case "2":
                    System.out.println("请输入要修改的学生编号：");
                    id = scanner.nextLine();
                    System.out.println("请输入新的学生姓名：");
                    name = scanner.nextLine();
                    manager.updateStudent(id, new Student(id, name));
                    break;
                case "3":
                    System.out.println("请输入要删除的学生编号：");
                    id = scanner.nextLine();
                    manager.deleteStudent(id);
                    break;
                case "4":
                    System.out.println("请输入查询关键字：");
                    String keyword = scanner.nextLine();
                    List<Student> results = manager.searchStudents(keyword);
                    for (Student student : results) {
                        System.out.println(student);
                    }
                    break;
                case "0":
                    try {
                        manager.saveToFile(filename);
                    } catch (IOException e) {
                        System.out.println("保存到文件失败。");
                    }
                    System.exit(0);
                    break;
                default:
                    System.out.println("无效选择，请重新输入。");
                    break;
            }
        }
    }
}
