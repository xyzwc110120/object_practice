package reflectDemo.methodDemo;

import java.lang.reflect.Method;
import java.util.Arrays;

class Student {

    public static void name(String name) {
        System.out.println("public static void test( " + name + " )");
    }

    // 可变参数：使用 ... 表示可变参数（变长参数是Java的一个语法糖，本质上还是基于数组实现的）
    public static void sleep(int... hours) {
        System.out.println("public static void sleep( " + Arrays.toString(hours) + " )");
    }

    public static void study(String... subjects) {
        System.out.println("public static void study( " + Arrays.toString(subjects) + " )");
    }

}

public class MethodInvokeDemo2 {

    public static void main(String[] args) throws ReflectiveOperationException {
        Class<Student> studentClass = Student.class;
        Method method = studentClass.getMethod("name", String.class);

        // 如果底层方法是静态的，那么可以忽略指定的底层方法所属的类的对象。该参数可以为 null
        method.invoke(null, "大大大大大哥");
        method.invoke(null, new Object[]{"大大大大大哥"});

        // 情况1：数组的元素类型是基本类型
        // 课表参数的底层为数组，所以使用反射获取该方法的 Method 对象时，直接使用该参数类型的数组的字节码对象
        method = studentClass.getMethod("sleep", int[].class);
        // method.invoke(null, 1, 2, 3, 4);     // java.lang.IllegalArgumentException: wrong number of arguments：参数数量错误
        // 因为在底层可变参数其实是一个数组对象，所以这里传入一个数组对象
        method.invoke(null, new int[]{1, 2, 3, 4});
        method.invoke(null, new Object[]{new int[]{1, 2, 3, 4}});

        // 情况2：数组的元素类型是引用类型
        method = studentClass.getMethod("study", String[].class);
        // method.invoke(null, new String[]{"语文", "数学", "英语"});     // 个别参数（元素是引用类型的数组）会被自动解包
        method.invoke(null, new Object[]{new String[]{"语文", "数学", "英语"}});
        /*
            public Object invoke(Object obj, Object... args)：
                args 参数其实是一个 Object 类型的数组，所以不管任意类型的实参，统统作为 Object 数组的元素就可以了
        */
        studentClass.getMethod("name", String.class).invoke(null, new Object[]{"大大大大大哥"});
        studentClass.getMethod("sleep", int[].class).invoke(null, new Object[]{new int[]{1, 2, 3, 4}});
    }

}
