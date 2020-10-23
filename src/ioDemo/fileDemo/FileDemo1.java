package ioDemo.fileDemo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class FileDemo1 {


    public static void main(String[] args) throws IOException {
        System.out.println();
        test1();
        System.out.println();
        test2();
        System.out.println();
        test3();
        System.out.println();
        test4();
        System.out.println();
        test5();
    }

    private static void test1() {
        // 创建 File 对象
        // 通过文件路径字符串创建文件对象
        File file1 = new File("G:/practice/object_practice/src/ioDemo/file/txt/delete-test1.txt");

        // File(String 文件所在目录, String 文件名称)
        File file2 = new File("G:/practice/object_practice/src/ioDemo/file/txt", "delete-test1.txt");

        // File(File 文件所在目录, String 文件名称)
        File dir = new File("G:/practice/object_practice/src/ioDemo/file/txt");
        File file3 = new File(dir, "delete-test1.txt");

        // File 类中的 toString() 方法调用的 getPath() 方法，获取文件路径
        System.out.println(file1);
        System.out.println(file2);
        System.out.println(file3);
    }

    /**
        操作 File 路径和名称：
            File getAbsoluteFile()：获取绝对路径（返回 File 对象）
            String getAbsolutePath()：获取绝对路径（返回字符串）
            String getPath()：获取文件路径（创建 File 对象时传入的路径，若是相对路径，则返回相对路径）
            String getName()：获取文件名称
            File getParentFile()：获取上级目录文件对象（若创建 File 对象传入的是相对路径，则返回的也是相对目录，返回 File 对象）
            String getParent()：获取上级目录路径（若创建 File 对象传入的是相对路径，则返回的也是相对目录，返回字符串）
    */
    private static void test2() {
        // 使用相对路径创建 File 对象
        File file = new File("src/ioDemo/txt/delete-test1.txt");
        System.out.println(file.getAbsoluteFile());     // G:\practice\object_practice\src\ioDemo\fileDemo\delete-test1.txt
        System.out.println(file.getAbsolutePath());     // G:\practice\object_practice\src\ioDemo\fileDemo\delete-test1.txt
        System.out.println(file.getPath());             // G:\practice\object_practice\src\ioDemo\fileDemo\delete-test1.txt
        System.out.println(file.getName());             // delete-test1.txt
        System.out.println(file.getParentFile());       // G:\practice\object_practice\src\ioDemo\fileDemo
        System.out.println(file.getParent());           // G:\practice\object_practice\src\ioDemo\fileDemo
    }

    /**
        检测 File 状态的方法：
            boolean	canExecute()：判断是否是可执行文件
            boolean	canRead()：判断文件是否可读
            boolean	canWrite()：判断文件是否可写
            boolean	isHidden() ：判断该文件是否隐藏文件
            long lastModified()：获取文件的最后修改时间（返回时间戳）
            long length()：获取文件的长度大小（单位：字节）
    */
    private static void test3() {
        File file = new File("src/ioDemo/file/txt/delete-test1.txt");
        System.out.println(file.canExecute());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isHidden());
        System.out.println(file.lastModified());        // 返回的是时间戳
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateFormat.format(file.lastModified()));
        System.out.println(file.length());
    }

    /**
        File 类中方法-文件操作：
            boolean isFile()：判断是否是文件
            boolean exists()：判断文件或目录是否存在
            boolean createNewFile()：创建新的文件（若文件父目录不存在，则无法新建文件）
            boolean renameTo(File dest)：重新修改文件或目录名称，并将文件转移至 dest 的路径下
            boolean delete()：删除文件或目录
            void deleteOnExit()：在 JVM 停止时删除文件或目录
            static File createTempFile(String prefix, String suffix, File directory)：创建临时文件：
                                        prefix：文件名前缀
                                        suffix：文件名后缀（若为空，则默认后缀为 .tmp）
                                        directory：文件路径（若为空，则保存至默认临时文件目录）
    */
    private static void test4() throws IOException {
        File dir = new File("src/ioDemo/file/test");
        File file = new File(dir, "test.test");
        System.out.println(file.isFile());
        // 如果文件不存在，则新建文件
        if (!file.exists()) {
            if (!file.createNewFile()) {
                System.out.println("创建文件失败");
            }
        } else {
            if (!file.renameTo(new File(dir, "test.test"))) {
                System.out.println("文件名修改失败");
            } else {
                System.out.println(file.getAbsolutePath());
                if (!file.delete()) {
                    System.out.println("删除失败");
                }
            }

        }
        // 创建临时文件
        /*File tempFile = File.createTempFile("temp", ".tmp", new File("src/ioDemo/file/tmp"));
        System.out.println(tempFile.getAbsolutePath());*/
    }

    /**
        File 类中的方法-目录操作：
            boolean isDirectory()：判断是否是目录
            boolean mkdir()：创建文件目录：
                                    调用该方法的 File 对象要指向文件目录，而不是文件，否则无法创建；
                                    若该目录存在，则创建失败；
                                    若该目录的父目录不存在，则创建失败。
            boolean mkdirs()：创建文件目录，包括所有不存在的父级目录
            String[] list()：列出目录下所有文件及子目录
            File[] listFiles()：列出目录下所有文件及目录对象
            static File[] listRoots()：列出系统盘符
             boolean renameTo(File dest)：重新修改文件或目录名称，并将文件转移至 dest 的路径下
             boolean delete()：删除文件或目录
             void deleteOnExit()：在 JVM 停止时删除文件或目录
    */
    private static void test5() {
        File dir1 = new File("src/ioDemo/file/test");
        System.out.println(dir1.isDirectory());
        if (dir1.exists()) {
            if (dir1.delete()) {
                System.out.println("删除目录成功");
            }
        } else {
            if (dir1.mkdir()) {
                System.out.println("创建目录成功");
            }
        }

        File dir2 = new File("src/ioDemo/file");
        String[] fileNames = dir2.list();
        for (String fileName: fileNames) {
            System.out.print(fileName + "，");
        }
        System.out.println();
        File[] files = dir2.listFiles();
        for (File file : files) {
            System.out.println(file);
        }
        File[] systemFiles = File.listRoots();
        for (File systemFile : systemFiles) {
            System.out.println(systemFile);
        }
    }
}
