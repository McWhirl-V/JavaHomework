package cn.mcwhirl.chapter.chapter3.work5;

import java.io.Serializable;

public class StudentInfo implements Serializable {
    private String id;
    private String name;
    private int age;
    private String place;
    private String college;
    private String major;
    private String clas_s;

    public StudentInfo(String id, String name, int age, String place, String college, String major, String clas_s) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.place = place;
        this.college = college;
        this.major = major;
        this.clas_s = clas_s;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClas_s() {
        return clas_s;
    }

    public void setClas_s(String clas_s) {
        this.clas_s = clas_s;
    }
    @Override
    public String toString(){
        return "姓名：" + this.name + "\t学号：" + this.id
                + "\t年龄：" + this.age + "\t家庭住址：" + this.place+"\t学院："
                +this.college+"\t专业："+this.major+"\t\t班级："+this.clas_s;
    }
}
