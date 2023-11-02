package cn.mcwhirl.chapter.chapter3.work5;

import java.io.*;
import java.util.ArrayList;

public class FileAccess {
    private File file;
    private ObjectInputStream objectInputStream=null;

    private ObjectOutputStream objectOutputStream=null;
    FileAccess(String path){
        this.file=new File(path);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void saveStudents(ArrayList<StudentInfo> list){
        try {
            objectOutputStream=new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(list);
            objectOutputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally{
            if(objectOutputStream!=null){
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public ArrayList<StudentInfo> readStudents(ArrayList<StudentInfo> list) throws RuntimeException {
        try {
            FileInputStream is=new FileInputStream(file);
            if(file.length()==0){
                System.out.println("还未录入数据");
                is.close();
                return list;
            }else{
                objectInputStream = new ObjectInputStream(is);
                list=(ArrayList<StudentInfo>) objectInputStream.readObject();
                return list;
            }
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
