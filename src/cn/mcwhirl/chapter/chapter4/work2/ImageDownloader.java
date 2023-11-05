package cn.mcwhirl.chapter.chapter4.work2;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ImageDownloader {
    public void imageDownload(){
        String imageURL = "https://th.bing.com/th/id/R.143444cb54434515eb63a809899bd086?rik=8Dc2XJ4MVVggtw&riu=http%3a%2f%2fi1.hdslb.com%2fbfs%2farchive%2f176fdf5ba89c5eff3c0f300aaf53967dcddff923.jpg&ehk=BwMlrEylqdyCNBntjCTyc7DK%2fMsT%2f7CU7ioseRoJoMo%3d&risl=&pid=ImgRaw&r=0";
        String saveAs = "cxk.jpg";

        new Thread(() -> {
            try {
                URL url = new URL(imageURL);
                File file= new File(saveAs);

                try(InputStream in = url.openStream();) {
                    Files.copy(in,file.toPath(), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if(Desktop.isDesktopSupported()){
                    Desktop desktop = Desktop.getDesktop();
                    if (file.exists()) {
                        desktop.open(file);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
