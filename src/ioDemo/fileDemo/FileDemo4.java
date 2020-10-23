package ioDemo.fileDemo;

import java.io.File;

// 批量修改文件名称案例
public class FileDemo4 {

    public static void main(String[] args) {
        File dir = new File("src/ioDemo/file/txt");
        File[] files = dir.listFiles();
        // 需要删除的字符串
        String deleteString = "delete-";
        for (File file : files) {
            // 如果文件中存在需要删除的字符串
            if (file.getName().contains(deleteString)) {
                String newName = file.getName().replace(deleteString, "");
                file.renameTo(new File(dir, newName));
            }
        }
    }
}
