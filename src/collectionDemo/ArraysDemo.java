package collectionDemo;

import java.util.Arrays;
import java.util.List;

public class ArraysDemo {

    public static void main(String[] args) {
        // 把数组转换为 List 对象
        List<String> list1 = Arrays.asList("A", "B", "C", "D");

        // 删除下标为 0 的元素
        list1.remove(0);    // 抛出异常：test.lang.UnsupportedOperationException（不支持功能异常）
        /*
         通过 Arrays.asList 方法得到的 List 对象的长度是固定的，不可新增和删除，但是可以修改
         原因：
            asList 方法返回的 ArrayList 对象不是 test.util.ArrayList 对象，而是 Arrays 类中的内部类 ArrayList 类对象

         部分源码：
            public class Arrays {

                // 私有化构造器，禁止外界实例化
                private Arrays() {};

                public static <T> List<T> asList(T... a) {
                    return new ArrayList<>(a);
                }

                // 内部类 ArrayList
                private static class ArrayList<E> extends AbstractList<E> implements RandomAccess, test.io.Serializable
                {
                    private static final long serialVersionUID = -2764017481108945198L;
                    private final E[] a;

                    ArrayList(E[] array) {
                        a = Objects.requireNonNull(array);
                    }

                    ...
                }
        */


        // 在方法中直接写入数组，是会自动装箱
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5);
        int[] arr = {1, 2, 3, 4};
        // List<int> list3 = Arrays.asList(args);   // 如果传入一个数组标量，会直接把数组当作对象，不会自动装箱
    }
}
