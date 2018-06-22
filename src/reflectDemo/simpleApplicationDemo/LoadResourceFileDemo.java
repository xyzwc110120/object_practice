package reflectDemo.simpleApplicationDemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

// 加载资源文件
public class LoadResourceFileDemo {

    public static void main(String[] args) {
        loadWay1();
        loadWay2();
        loadWay3();
    }

    /**
     * 方式1：使用绝对路径的方式加载（该方法只能在本地使用，不好）
     */
    private static void loadWay1() {
        Properties properties = new Properties();
        try (InputStream in = new FileInputStream("G:/practice/object_practice/resources/db.properties")) {
            properties.load(in);
            System.out.println(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 方式2：使用相对路径 - 相对于当前加载资源文件的字节码路径
     *          它是相对于当前加载资源的类的字节码文件所在的路径
     */
    private static void loadWay2() {
        Properties properties = new Properties();
        try (
                // InputStream in = LoadResourceFileDemo.class.getResourceAsStream("db.properties")
                InputStream in = LoadResourceFileDemo.class.getResourceAsStream("this.properties")
        ) {
            properties.load(in);
            System.out.println(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 方式3：使用相对路径 - 相对于 classpath 的根路径（字节码输出目录）
     *          此时得使用 ClassLoader （类加载器），类加载器默认就是从 classpath 根路径去寻找文件的
     */
    private static void loadWay3() {
        Properties properties = new Properties();
        /*
        获得 ClassLoader 对象的两种方法：
                1：通过 Class 对象调用 getClassLoader() 方法
                2：通过 Thread 对象调用 getContextClassLoader() 方法
        */
        // ClassLoader loader = LoadResourceFileDemo.class.getClassLoader();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try (
                InputStream in = loader.getResourceAsStream("db.properties")
        ) {
            properties.load(in);
            System.out.println(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
