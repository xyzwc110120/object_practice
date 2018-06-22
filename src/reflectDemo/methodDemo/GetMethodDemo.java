package reflectDemo.methodDemo;

import java.lang.reflect.Method;

class User {

    public void test() { }

    public static String test(String name) {
        return name;
    }

    private String test(String name, int age) {
        return name + "，" + age;
    }

}

// 获取 User 类中的方法
public class GetMethodDemo {

    public static void main(String[] args) throws NoSuchMethodException {
        // 1：获取方法所在类的字节码对象
        Class<User> userClass = User.class;
        // 2：获取方法
        getAllMethods(userClass);
        getSuchMethod(userClass);
    }

    /**
     * 获取类中所有方法
     *
     * @param clz 类的 Class 对象
     * @param <T> Class 对象的类型
     */
    private static <T> void getAllMethods(Class<T> clz) {
        System.out.println("-------------------------------");
        // Method[]	getMethods()：获取包括自身和继承过来的所有 public 修饰的方法对象
        Method[] methods = clz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("-------------------------------");

        // Method[]	getDeclaredMethods()：获取自身类中所有方法对象，和访问权限无关（不包括继承的方法）
        methods = clz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("-------------------------------");
    }

    private static <T> void getSuchMethod(Class<T> clz) throws NoSuchMethodException {
        /*
        Method getMethod(String name, Class<?>... parameterTypes)：获取指定的一个 public 修饰的方法对象（包括继承的）。
            name：要获取的方法的名称
            parameterTypes：要获取的方法的参数的类型的 Class 对象
        */
        Method method = clz.getMethod("test");
        System.out.println(method);
        method = clz.getMethod("test", String.class);
        System.out.println(method);
        // 获取继承于 Object 类中的 toString 方法
        method = clz.getMethod("toString");
        System.out.println(method);
        /*
        Method getDeclaredMethod(String name, Class<?>... parameterTypes)： 获取指定的一个本类中的方法对象，和访问权限无关（不包括继承的方法）
            name：要获取的方法的名称
            parameterTypes：要获取的方法的参数的类型的 Class 对象
        */
        method = clz.getDeclaredMethod("test", String.class, int.class);
        System.out.println(method);
    }

}
