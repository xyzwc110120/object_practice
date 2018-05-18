package ioDemo.file.serializableDemo;

import java.io.*;

// 使用对象流做序列化与反序列化操作
public class ObjectStreamDemo {

    public static void main(String[] args) {
        File file = new File("src/ioDemo/file/obj.txt");
        writeObject(file);
        readObject(file);
    }

    // 写出对象数据至文件中
    private static void writeObject(File file) {
        try (
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))
        ) {
            // 只能将实现 java.io.Serializable 接口的对象写入流中，否则报错：java.io.NotSerializableException
            out.writeObject(new User("哦呵呵", "男", 18));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 从文件中读取对象数据
    private static void readObject(File file) {
        try (
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))
        ) {
            User user = (User) in.readObject();
            System.out.println(user);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
