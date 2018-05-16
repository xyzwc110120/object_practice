package genericType;

import java.util.ArrayList;
import java.util.List;

public class GenericDemo2 {

    public static void main(String[] args) {
        // 创建一个 Integer 类型的集合
        List<Integer> list1 = new ArrayList<>();
        list1.add(123);

        // 将 Integer 类型的集合赋予无泛型的集合，手动擦除泛型
        List list2 = list1;
        // 此时集合中的元素类型变为 Object
        list2.add("ABC");

        // 堆污染
        // List<String> list3 = list1;      因为集合类型不同，无法赋予
        List<String> list3 = list2;
        // 类型转换异常：ClassCastException: test.lang.Integer cannot be cast to test.lang.String
        String num = list3.get(0);
        // 因为集合中的第一个元素是 Integer 类型的，此时相当于： String num = 123;
    }

}
