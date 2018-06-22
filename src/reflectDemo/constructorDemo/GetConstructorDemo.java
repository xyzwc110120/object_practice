package reflectDemo.constructorDemo;

import java.lang.reflect.Constructor;

class User {

    public User() { }

    public User(String name) { }

    private User(String name, int age) { }

}

// 获取构造器
public class GetConstructorDemo {

    public static void main(String[] args) throws NoSuchMethodException {
        // 1：获取构造器所在类的字节码对象
        Class<User> userClass = User.class;
        // 2：获取字节码对象中的构造器
        getAllConstructors(userClass);
        getSuchConstructor(userClass);
    }

    /**
     * 获取所有构造器
     *
     * @param clz 需要获取构造器的类的 Class 对象
     * @param <T> Class 对象类型
     */
    private static <T> void getAllConstructors(Class<T> clz) {
        // Constructor<?>[] getConstructors()：该方法只能返回当前 Class 对象所表示类的 public 修饰的构造器
        Constructor<?>[] constructors = clz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("-----------------------------------------");
        // Constructor<?>[]	getDeclaredConstructors()：获取当前 Class 对象所表示类的所有的构造器，不管是什么访问权限
        constructors = clz.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("-----------------------------------------");
    }

    /**
     * 获取指定构造器
     *
     * @param clz clz 需要获取构造器的类的 Class 对象
     * @param <T> Class 对象类型
     * @throws NoSuchMethodException 未找到该方法
     */
    private static <T> void getSuchConstructor(Class<T> clz) throws NoSuchMethodException {
        // Constructor<T> getConstructor(Class<?>... parameterTypes)：获取当前 Class 对象表示类中指定的一个 public 的构造器
        // parameterTypes 参数：构造器参数类型的 Class 对象
        System.out.println(clz.getConstructor());
        System.out.println(clz.getConstructor(String.class));
        // Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes)：获取当前 Class 对象所表示类中指定的一个构造器
        System.out.println(clz.getDeclaredConstructor(String.class, int.class));
    }

}
