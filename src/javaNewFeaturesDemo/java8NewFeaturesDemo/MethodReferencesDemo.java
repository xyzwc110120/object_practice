package javaNewFeaturesDemo.java8NewFeaturesDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 设置一个函数式接口，规定泛型 T 为 List 接口的子类
@FunctionalInterface
interface ListInterface<T extends List<?>> {
    T getList();
}

// 设置一个没有返回值的函数式接口
@FunctionalInterface
interface NoReturn {
    void test(String str);
}

// 设置一个返回 String 类型的函数式接口
@FunctionalInterface
interface ReturnString {
    String test(String str);
}


// 方法引用示例
public class MethodReferencesDemo {

    public static void main(String[] args) {
        Integer[] integers = new Integer[]{1, 2, 4, 1, 2, 6, 4, 6};
        /*
            匿名内部类的写法：
                Arrays.sort(integers, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return Integer.compare(o1, o2);
                    }
                });

            lambda 表达式的写法：
                Arrays.sort(integers, (o1, o2) -> Integer.compare(o1, o2));

            从上面的两种写法中可以看出来，Comparator 接口中的 compare 抽象方法的参数列表与实现 compare 方法的 Integer 类中的
             compare 方法的参数列表一致，并且返回值也一致，那么我们可以使用“类名 :: 方法名”来再次简化 lambda 表达式
        */
        // 类名 :: 静态方法
        Arrays.sort(integers, Integer :: compare);
        System.out.println(Arrays.toString(integers));

        System.out.println();
    }

    // 通过对象调用方法的引用方法
    public Integer[] sort(Integer[] t) {
        // 对象 :: 普通方法
        // MethodReferencesDemo demo = new MethodReferencesDemo();
        // Arrays.sort(t, demo :: compare);
        Arrays.sort(t, this :: compare);
        return t;
    }
    public int compare(int x, int y) {
        return Integer.compare(x, y);
    }

    // 构造器引用：
    public void toList() {
        // asList(() -> new ArrayList<Integer>(), 2, 3, 4, 2, 5, 3);
        asList(ArrayList :: new, 2, 3, 4, 2, 5, 3);
    }
    public <T> void asList(ListInterface listInterface, T... ts) {
        List<T> list = listInterface.getList();
        for (T t : ts) {
            list.add(t);
        }
    }

    // 函数式接口中的抽象方法与实现该抽象方法所引用的方法返回值不一致时
    public void print() {
        noReturn(Integer :: new, "HaHaHaHaHa");
        noReturn(String :: new, "HaHaHaHaHa");
        // printlnString(Integer :: new, 12345);
        printlnString(String :: new, "HaHaHaHaHa");
        /*
            可以发现：
                1：若函数式接口中的抽象方法没有返回值，那么就不必管实现该抽象方法的方法的返回值；
                2：若函数式接口中的抽象方法有返回值，那么实现该抽象方法的方法返回值就要保持一致。
        */
    }
    public void noReturn(NoReturn nr, String str) {
        nr.test(str);
    }
    public void printlnString(ReturnString rs, String str) {
        System.out.println(rs.test(str));
    }

}
