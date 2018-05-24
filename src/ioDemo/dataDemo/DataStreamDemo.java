package ioDemo.dataDemo;

import java.io.*;

// 数据流操作
public class DataStreamDemo {

    public static void main(String[] args) {
        File file = new File("src/ioDemo/file/txt/test1.txt");
        write(file);
        read(file);
    }

    private static void write(File file) {
        try (
                DataOutputStream out = new DataOutputStream(new FileOutputStream(file))
        ) {
            out.writeByte(65);
            out.writeChar('牛');
            out.writeUTF("逼真牛逼");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void read(File file) {
        try (
                DataInputStream in = new DataInputStream(new FileInputStream(file))
        ) {
            System.out.println(in.readByte());
            System.out.println(in.readChar());
            System.out.println(in.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
