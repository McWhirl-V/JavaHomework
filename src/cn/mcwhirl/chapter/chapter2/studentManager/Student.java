package cn.mcwhirl.chapter.chapter2.studentManager;

public class Student {
    private String name;
    private double javaGrade;
    private double htmlGrade;
    private double sqlGrade;

    //学生信息类
    public Student(String name,double javaGrade,double htmlGrade,double sqlGrade){
        this.name = name;
        this.javaGrade = javaGrade;
        this.htmlGrade = htmlGrade;
        this.sqlGrade = sqlGrade;
    }
    public String getName() {
        return name;
    }

    public double getJavaGrade() {
        return javaGrade;
    }

    public double getHtmlGrade() {
        return htmlGrade;
    }

    public double getSqlGrade() {
        return sqlGrade;
    }

    public double getTotalGrade() {
        return javaGrade + htmlGrade + sqlGrade;
    }

    public double getAverageGrade() {
        return getTotalGrade() / 3;
    }
}
