package reflectDemo.reflectSomeApiDemo;

import java.lang.reflect.Modifier;

enum Day {
    SUN, MON, TUE, WED, THU, FRI, SAT;
}


// Class 类部分 Api 示例
abstract public class ClassApiDemo {

    public static void main(String[] args) throws ReflectiveOperationException {
        Class clz = ClassApiDemo.class;
        // int getModifiers()：返回此类或接口以整数编码的 Java 语言修饰符。
        int mod = clz.getModifiers();
        System.out.println("该类的修饰符：" + mod);        // 1025
        /*
            java.lang.reflect.Modifier 类中，每种修饰符都对应了一个十六进制整数常量，如：
                public static final int PUBLIC = 0x00000001;
                public static final int PRIVATE = 0x00000002;
                public static final int PROTECTED = 0x00000004;
                等...
        */
        System.out.println(Modifier.toString(mod));

        // 获取类的全限定名
        System.out.println("该类的全限定名：" + clz.getName());
        // 获取类的简单名称
        System.out.println("该类的简单类名：" + clz.getSimpleName());

        // 获取类的包对象
        Package p = clz.getPackage();
        System.out.println("该类的包名：" + p.getName());

        // 获取类的直接父类的 Class 对象
        Class superClz = clz.getSuperclass();
        System.out.println("该类的直接父类名称：" + superClz.getName());

        // 获取枚举类型的类的字节码对象
        Class<Day> enumClz = Day.class;
        System.out.println(enumClz);
        // 枚举不能通过反射获取构造器对象，也就不能通过反射创建对象，所以枚举比单例更安全
        // Constructor<Day> con = enumClz.getDeclaredConstructor();
        // con.setAccessible(true);
        // con.newInstance();
    }

}
