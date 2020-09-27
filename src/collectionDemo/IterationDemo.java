package collectionDemo;

import java.util.*;

// 集合迭代示例
public class IterationDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        forDemo(list);
        System.out.println("----------------------------");
        forEachDemo(list);
        System.out.println("----------------------------");
        iteratorByWhile(list);
        System.out.println("----------------------------");
        iteratorByFor(list);
        System.out.println("----------------------------");

        Vector<String> vector = new Vector<>();
        vector.add("A");
        vector.add("B");
        vector.add("C");
        vector.add("D");
        vector.add("E");
        EnumerationDemo(vector);
    }

    /**
     * for 循环
     */
    private static void forDemo(List<String> list) {
        for (int index = 0; index < list.size(); index++) {
            String str = list.get(index);       // 从集合中取出指定索引位置的元素
            System.out.println(str);
        }
    }

    /**
     * for-each，增强 for 循环，其实底层通过迭代器来实现的：
     *      for(类型  变量名  :  数组对象 / Iterable 实例) {
     *          // TODO
     *      }
     */
    private static void forEachDemo(List<String> list) {
        for (String str : list) {
            System.out.println(str);
        }
    }

    /**
     * 使用 while 循环操作迭代器 Iterator
     */
    private static void iteratorByWhile(List<String> list) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * 使用 for 循环来操作迭代器 Iterator（性能要比使用 while 好点）
     */
    private static void iteratorByFor(List<String> list) {
        for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
            System.out.println(iterator.next());
        }
        // 迭代完后会立即释放迭代器资源（因为此时迭代器是局部变量）
    }

    /**
     * 古老的迭代器对象 Enumeration
     */
    private static void EnumerationDemo(Vector<String> vector) {
        Enumeration<String> enumeration = vector.elements();
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
    }
}
