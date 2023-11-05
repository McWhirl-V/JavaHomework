package cn.mcwhirl.chapter.chapter4.work1;

import java.io.*;

public class FileCopy {
    public void FileCopyRun(){
        String sourceFile = "source.txt";
        String targetFile = "target.txt";

        try (
                BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(targetFile))
        ) {
            String line;
            // 逐行读取文件
            while ((line = reader.readLine()) != null) {
                // 将每一行写入到目标文件
                writer.write(line);
                // 写入一个换行符，以保持文件的格式
                writer.newLine();
            }
            System.out.println("文件复制完成！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
