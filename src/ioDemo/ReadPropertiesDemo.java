package ioDemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

// 读取资源文件
public class ReadPropertiesDemo {

    public static void main(String[] args) throws IOException {
        // 创建 Properties 对象
        Properties properties = new Properties();
        // 加载输入流中的数据，加载之后，数据都在 properties 对象中
        properties.load(new FileInputStream("src/ioDemo/file/test.properties"));
        System.out.println(properties);
        System.out.println(properties.getProperty("username"));
        System.out.println(properties.getProperty("password"));
    }

}
