package reflectDemo.classInstanceDemo;

import java.util.Date;

// 获取字节码对象：Class 对象
public class ClassInstanceDemo {

    public static void main(String[] args) throws ClassNotFoundException {
        // 获取 java.util.Date 类的字节码对象

        // 方式1：使用 class 属性
        Class<java.util.Date> clz1 = java.util.Date.class;
        // 方式2：通过对象的 getClass 方法来获取，getClass 方法是 Object 类中的方法
        java.util.Date date = new Date();
        Class<?> clz2 = date.getClass();
        // 方式3：通过 Class 类中的静态方法 forName(String className); （注意：这里要用类的全限定名）
        Class<?> clz3 = Class.forName("java.util.Date");

        System.out.println(clz1);
        System.out.println(clz2);
        System.out.println(clz3);

        System.out.println(clz1 == clz2);       // true
        System.out.println(clz1 == clz3);       // true
        System.out.println(clz2 == clz3);       // true
        // 注意：同一个类在 JVM 中只存在一份字节码对象，也就是说 clz1 == clz2 == clz3
        // 以后时用的最多的是方式3，在框架中大量使用
    }

}
