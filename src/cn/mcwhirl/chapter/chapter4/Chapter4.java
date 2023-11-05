package cn.mcwhirl.chapter.chapter4;

import cn.mcwhirl.chapter.chapter4.work1.FileCopy;
import cn.mcwhirl.chapter.chapter4.work2.ImageDownloader;
import cn.mcwhirl.chapter.chapter4.work3.WeatherTool;
import cn.mcwhirl.utils.Tool;

public class Chapter4 {
    private Tool tool = new Tool();

    public void chapterMenu() {
        while (true) {
            System.out.println(" ");
            System.out.println("------------------ 作业4 ------------------");
            System.out.println("请选择题目序号: 1 —— TXT文件转移；");
            System.out.println("请选择题目序号: 2 —— 下载一张图片；");
            System.out.println("请选择题目序号: 3 —— 天气的实时查询；");
            System.out.println("0 —— 退出");
            System.out.println("-----------------------------------------");
            int option = tool.inputInt();
            switch (option) {
                case 1:
                    work1();
                    break;
                case 2:
                    work2();
                    break;
                case 3:
                    work3();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("无效的选项，请重新输入。");
            }
        }
    }

    private void work3() {
        WeatherTool weatherTool = new WeatherTool();
        weatherTool.weatherTool();
    }

    private void work2() {
        ImageDownloader imageDownloader = new ImageDownloader();
        imageDownloader.imageDownload();
    }

    private void work1() {
        FileCopy fileCopy = new FileCopy();
        fileCopy.FileCopyRun();
    }
}
