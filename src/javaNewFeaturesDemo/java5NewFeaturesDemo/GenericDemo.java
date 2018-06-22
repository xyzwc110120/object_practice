package javaNewFeaturesDemo.java5NewFeaturesDemo;

import java.util.ArrayList;
import java.util.List;

// 泛型示例
public class GenericDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        String str = list.get(1);
        /*
            编译后：String str = (String)list.get(1);
            其实底层用的强转
        */

        // 堆污染
        // 将 List<String> 转换为 List<Object>
        List list1 = list;
        // 将 List 转换为 List<Integer>
        List<Integer> list2 = list1;
        Integer i = list2.get(1);
        /*
            类型转换异常：java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer
            因为集合元素还是为 String 类型，而泛型类型却改变了，类型不一致
        */
    }

}
