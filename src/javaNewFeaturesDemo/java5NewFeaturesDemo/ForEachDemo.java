package javaNewFeaturesDemo.java5NewFeaturesDemo;

import java.util.ArrayList;
import java.util.Arrays;

// 增强 for 循环案例
public class ForEachDemo {

    public static void main(String[] args) {
        operatorArray(new String[]{"A", "B", "C", "D"});
        System.out.println("------------------------------");
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        operationIterable(list);
    }

    /**
     * for-each 操作数组
     */
    private static void operatorArray(String[] values) {
        if (values != null) {
            for (String value : values) {
                value = "F";
                System.out.print(value);
            }
            System.out.println(Arrays.toString(values));
        }
        /*
        编译后：
            if (values != null) {
                String[] var1 = values;
                int var2 = values.length;

                // 可以看出底层使用的 for 循环
                for(int var3 = 0; var3 < var2; ++var3) {
                    String var10000 = var1[var3];
                    String value = "F";
                    System.out.print(value);
                }
                System.out.println(Arrays.toString(values));
            }
        */
    }

    /**
     * for-each 操作 Iterable 对象
     */
    private static void operationIterable(Iterable<String> values) {
        if (values != null) {
            for (String value : values) {
                System.out.print(value);
            }
            /*
            编译后：
                if (values != null) {
                    // 底层使用迭代器遍历
                    Iterator var1 = values.iterator();
                    while(var1.hasNext()) {
                        String value = (String)var1.next();
                        System.out.println(value);
                    }
                }
            */
        }
    }

}
