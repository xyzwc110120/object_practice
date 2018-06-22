package reflectDemo.methodDemo;

import java.lang.reflect.Method;

class Person {

    public void test() {
        System.out.println("调用方法：public void test()");
    }

    public void test(String name) {
        System.out.println("调用方法：public void test( " + name + " )");
    }

    private String test(String name, int age) {
        System.out.println("调用方法：private void test( " + name + ", " + age + " )");
        return name + "，" + age;
    }

}

// 使用反射调用方法
public class MethodInvokeDemo {

    public static void main(String[] args) throws ReflectiveOperationException {
        /*
            1：获取方法所在类的字节码对象
            2：获取方法对象
            3：使用反射调用方法（调用 Method 对象的 Object invoke(Object obj, Object... args) 方法）
                Object invoke(Object obj, Object... args)： 调用当前 Method 对象所表示的方法
                    obj：被调用的底层方法所属的类的对象
                    args：调用方法时传递的实际参数
                    返回：被调用方法的返回值
        */
        Class<Person> personClass = Person.class;
        Method method = personClass.getMethod("test");
        // 获取方法所属的类的对象
        Object object = personClass.newInstance();
        Object result = method.invoke(object);
        System.out.println(result);         // null：因为没有返回值
        method = personClass.getMethod("test", String.class);
        result = method.invoke(object, "哇哈哈");
        System.out.println(result);         // null：因为没有返回值
        method = personClass.getDeclaredMethod("test", String.class, int.class);
        // 设置为可访问的
        method.setAccessible(true);
        result = method.invoke(object, "哇哈哈", 22);
        System.out.println(result);
    }

}
