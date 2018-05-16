package ioDemo.fileDemo;

import java.io.File;

// 使用递归列出指定目录中所有的子文件
public class FileDemo2 {

    public static void main(String[] args) {
        // 指定一个目录
        File file = new File("src/ioDemo");
        listAllFiles(file);
    }

    private static void listAllFiles(File file) {
        // 获取指定目录的所有子文件及子目录
        File[] files = file.listFiles();
        for (File chileFile : files) {
            // 打印文件
            System.out.println(chileFile);
            // 若 chileFile 指向是目录，则递归，获取目录中的文件
            if (chileFile.isDirectory()) {
                listAllFiles(chileFile);
            }
        }
    }

}
