package collectionDemo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo1 {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        map.put("key5", "value5");

        // Map 接口并没有继承于 Collection 接口，也没有继承于 Iterable 接口，所以不能直接用 foreach 遍历
        // for (String k : map) { }

        // 获取 Map 中所有 key 组成的集合（key 是不能重复的，类似于 Set 集合）
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key + "-" + map.get(key));
        }
        System.out.println("--------------------------");

        // 获取 Map 中所有 value 组成的集合（value 是可以重复的，类似于 List 集合）
        Collection<String> values = map.values();
        for (String value : values) {
            System.out.println(value);
        }
        System.out.println("--------------------------");

        // 获取 Map 中的 Entry(key-value)，Map 接口中有个内部接口 Entry<K,V> 表示键值对
        // Entry 为 Map 中的内部类，所以是全局静态的，所以要用类名 Map.Entry 来调用
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }

    }

}
