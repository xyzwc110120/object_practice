package ioDemo.fileStreamDemo;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

// 系统属性
public class SystemDemo {

    public static void main(String[] args) {
        // 获取当前系统所有属性（返回 Properties 集合）
        Properties properties = System.getProperties();
        // 将 properties 中的键值对转换为 Set 集合
        Set<Map.Entry<Object, Object>> entries = properties.entrySet();
        // 遍历 properties
        for (Map.Entry<Object, Object> entry : entries) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        System.out.println();

        // 通过 key 获取系统属性的值
        System.out.println("java.version - " + System.getProperty("java.version"));
    }

}
