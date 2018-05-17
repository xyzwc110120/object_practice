package ioDemo.bufferedDemo;

import java.io.*;

// 节点流和缓冲流的性能对比
public class NodeStreamVSBufferStream {

    public static void main(String[] args) {
        File source = new File("src/ioDemo/file/txt/music.mp3");
        File target = new File("src/ioDemo/file/test/music.mp3");
        // nodeStreamBySingleByte(source, target);
        // bufferStreamBySingleByte(source, target);
        // nodeStreamByByteArray(source, target);
        bufferStreamByByteArray(source, target);
    }

    /**
     * 使用节点流，从磁盘文件中每次读取一个字节：22599ms
     */
    private static void nodeStreamBySingleByte(File source, File target) {
        long begin = System.currentTimeMillis();
        try (
                InputStream in = new FileInputStream(source);
                OutputStream out = new FileOutputStream(target)
        ) {
            int len;
            while ((len = in.read()) != -1) {
                out.write(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() - begin);
    }
    /**
     * 使用缓冲流，从内存中每次读取一个字节：192ms
     */
    private static void bufferStreamBySingleByte(File source, File target) {
        long begin = System.currentTimeMillis();
        try (
                InputStream in = new BufferedInputStream(new FileInputStream(source));
                OutputStream out = new BufferedOutputStream(new FileOutputStream(target))
        ) {
            int len;
            while ((len = in.read()) != -1) {
                out.write(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() - begin);
    }

    /**
     * 使用节点流，每次从磁盘文件中每次读写 1024 个字节：47ms
     */
    private static void nodeStreamByByteArray(File source, File target) {
        long begin = System.currentTimeMillis();
        try (
                InputStream in = new FileInputStream(source);
                OutputStream out = new FileOutputStream(target)
        ) {
            byte[] bytes = new byte[1024];
            int len;
            while ((len = in.read(bytes)) != -1) {
                out.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() - begin);
    }
    /**
     * 使用节点流，每次内存中每次读写 1024 个字节：21ms
     */
    private static void bufferStreamByByteArray(File source, File target) {
        long begin = System.currentTimeMillis();
        try (
                InputStream in = new BufferedInputStream(new FileInputStream(source));
                OutputStream out = new BufferedOutputStream(new FileOutputStream(target))
        ) {
            byte[] bytes = new byte[1024];
            int len;
            while ((len = in.read(bytes)) != -1) {
                out.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() - begin);
    }

}
