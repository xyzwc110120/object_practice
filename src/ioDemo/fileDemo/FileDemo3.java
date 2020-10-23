package ioDemo.fileDemo;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 列出指定文件的分层结构
public class FileDemo3 {

    public static void main(String[] args) {
        // 指定一个文件
        String filePath = "src/ioDemo/file/test/test.test";
        File file = new File(filePath);
        // 用来存储文件父目录名称
        List<String> parentNames = new ArrayList<>();
        // 见文件的父级目录名称存入集合
        listAllParent(parentNames, file);
        System.out.println(parentNames);
        // 颠倒 List 集合中的元素顺序
        Collections.reverse(parentNames);
        // 设置 StringBuilder 对象初始大小，避免默认大小不够去扩容
        StringBuilder sb = new StringBuilder(40);
        for (String name : parentNames) {
            sb.append(name).append(" > ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    // 向集合中填入父目录名称
    private static void listAllParent(List<String> parentNames, File file) {
        // 若不为顶级目录
        if (file.getParent() != null) {
            parentNames.add(file.getParentFile().getName());
            listAllParent(parentNames, file.getParentFile());
        }
    }
}
