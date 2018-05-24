package ioDemo.randomAccessDemo;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

// 在文件的任意位置读写
public class RandomAccessFileDemo {

    public static void main(String[] args) {
        File file = new File("src/ioDemo/file/txt/test1.txt");
        writer(file);
        read(file);
    }

    private static void writer(File file) {
        try (
                /*
                RandomAccessFile(File file, String mode)：
                RandomAccessFile(String name, String mode)：
                    mode 参数用以指定打开文件的访问模式：
                        值       含意
                        "r"	    以只读方式打开。调用结果对象的任何 write 方法都将导致抛出 IOException。
                        "rw"	打开以便读取和写入。如果该文件尚不存在，则尝试创建该文件。
                        "rws"	打开以便读取和写入，对于 "rw"，还要求对文件的内容或元数据的每个更新都同步写入到底层存储设备。
                        "rwd"  	打开以便读取和写入，对于 "rw"，还要求对文件内容的每个更新都同步写入到底层存储设备。
                */
                RandomAccessFile raf = new RandomAccessFile(file, "rw")
        ) {
            // public void setLength(long newLength)：设置此文件的长度
            raf.setLength(1024);        // 1M
            raf.writeByte(65);
            /*
            public final void writeUTF(String str)：
                使用 modified UTF-8 编码以与机器无关的方式将一个字符串写入该文件。首先，把两个字节从文件的当前文件指针写入到此文件，
            此值是实际写出的字节数，而不是该字符串的长度。在该长度之后，按顺序输出该字符串的每个字符，并对每个字符使用 UTF-8 修改版编码。
                所以写入的字节数为 2 + 2 * 3 = 8 个字节（2字节加上两个汉字的6字节（并不是每个汉字多加一个字节）），
            要是写入3个汉字，则写入 2 + 3 * 3 = 11 个字节。
            */
            raf.writeUTF("哦呵");
            raf.writeInt(18);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void read(File file) {
        try (
                // 只是读取文件，所以设置为只读模式
                RandomAccessFile raf = new RandomAccessFile(file, "r")
        ) {
            // public long getFilePointer()：返回此文件中的当前偏移量
            System.out.println("文件指针位置：" + raf.getFilePointer());       // 0
            System.out.println(raf.readByte());
            System.out.println("文件指针位置：" + raf.getFilePointer());       // 1
            System.out.println(raf.readUTF());
            System.out.println("文件指针位置：" + raf.getFilePointer());       // 9：因为 writeUTF 方法会在原字符的字节数上多写入两字节
            // public void seek(long pos)：设置文件指针位置
            raf.seek(0);
            System.out.println("文件指针位置：" + raf.getFilePointer());       // 0
            System.out.println(raf.readByte());
            System.out.println("文件指针位置：" + raf.getFilePointer());       // 1
            // public int skipBytes(int n)：跳过 n 个字节
            raf.skipBytes(8);
            System.out.println("文件指针位置：" + raf.getFilePointer());       // 9
            System.out.println(raf.readInt());
            System.out.println("文件指针位置：" + raf.getFilePointer());       // 13
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
