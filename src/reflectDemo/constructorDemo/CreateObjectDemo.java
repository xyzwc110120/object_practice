package reflectDemo.constructorDemo;

import java.lang.reflect.Constructor;

class Person {

    public Person() {
        System.out.println("公共无参构造器");
    }

    public Person(String name) {
        System.out.println("公共带参构造器：" + name);
    }

    private Person(String name, int age) {
        System.out.println("私有带参构造器：" + name + "，" + age);
    }

}

// 使用反射调用构造器 --> 创建对象
public class CreateObjectDemo {

    public static void main(String[] args) throws Exception {
        /*
            1：找到构造器所在类的字节码对象；
            2：获取构造器对象；
            3：使用反射，创建对象。
        */
        Class<Person> personClass = Person.class;
        Constructor<Person> con = personClass.getConstructor();
        // 调用构造器对象的 newInstance 方法来创建对象，并传入实参
        Person person = con.newInstance();
        // 如果调用外界可访问，同时没有参数的构造器，可以直接使用 Class 类中的 newInstance 方法创建对象
        person = personClass.newInstance();

        con = personClass.getConstructor(String.class);
        con.newInstance("哎哟喂");

        // 如果调用私有成员（Constructor, Field, Method），必须先设置为可访问的，
        // 否则会报异常：java.lang.IllegalAccessException（非法访问异常）
        con = personClass.getDeclaredConstructor(String.class, int.class);
        // 值为 true 则指示反射的对象在使用时应该取消 Java 语言访问检查。值为 false 则指示反射的对象应该实施 Java 语言访问检查。
        con.setAccessible(true);
        con.newInstance("哎哟喂", 18);
    }

}
