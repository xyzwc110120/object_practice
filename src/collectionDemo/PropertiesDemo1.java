package collectionDemo;

import java.util.Properties;

// 属性类
public class PropertiesDemo1 {

    public static void main(String[] args) {
        // 是 Map 的实现类，是 Hashtable 的子类
        Properties properties = new Properties();
        // key 和 value 都是 String 类型的
        // 尽量使用类中的 setProperty(String key, String value) 方法，而不是继承的 put(K key, V value) 方法
        properties.setProperty("username", "root");
        properties.setProperty("password", "admin");
        System.out.println(properties);

        // 根据 key 获取 value 值
        String val1 = properties.getProperty("username");
        // getProperty(String key, String defaultValue)：当 key 不存在时，返回默认值 defaultValue
        String val2 = properties.getProperty("username1", "该 key 不存在时，返回该默认值");
        System.out.println(val1);
        System.out.println(val2);
    }

}
