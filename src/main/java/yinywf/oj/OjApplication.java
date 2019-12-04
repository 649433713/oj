package yinywf.oj;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;

@SpringBootApplication
public class OjApplication {
    private static final String NAME = "answer.txt";

    public static void main(String[] args) throws IOException {
        //SpringApplication.run(OjApplication.class, args);

        String path = "/Users/yinywf/Documents/Projects/oj/src/main/java/yinywf/oj";        //要遍历的路径
        File file = new File(path);        //获取其file对象
        FileOutputStream fileOutputStream = new FileOutputStream(NAME, true);
        func(file, fileOutputStream);
    }

    private static void func(File file, FileOutputStream fileOutputStream) throws IOException {
        File[] fs = file.listFiles();
        for (File f : fs) {
            if (f.isDirectory())    //若是目录，则递归打印该目录下的文件
                func(f, fileOutputStream);
            if (f.isFile()){        //若是文件，直接打印

                FileInputStream fileInputStream = new FileInputStream(f);
                int len = 0;
                byte[] bytes = new byte[fileInputStream.available()];
                while ((len = fileInputStream.read(bytes)) != -1) {
                    fileOutputStream.write(bytes, 0, len);
                    fileOutputStream.flush();
                }
            }

        }
    }
}
