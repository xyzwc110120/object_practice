package ioDemo.fileReaderWriterDemo;

import java.io.*;

// ʹ���ļ��ַ�������ļ��Ŀ���
public class FileCopyDemo {

    public static void main(String[] args) {
        // 1������Դ��Ŀ�����
        File source = new File("src/ioDemo/file/txt/test4.txt");
        File target = new File("src/ioDemo/file/txt/test5.txt");
        try (
                // 2���������롢���������
                Reader reader = new FileReader(source);
                Writer writer = new FileWriter(target)
        ) {
            // 3������д����
            char[] chars = new char[10];
            int len;
            while ((len = reader.read(chars)) > 0) {
                writer.write(chars, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
