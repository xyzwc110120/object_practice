class Person1 {
    Person1() {
        System.out.println("Person1()：无参自定义构造方法");
    }

    Person1(String name) {
        System.out.println("Person1(String name)：有参自定义构造方法：" + name);
    }
}

/*
* 一个源文件中只能有一个 public 类
* 一个源文件可以有多个非 public 类
* public 类的类名应该和源文件的名称保持一致
* */
public class PracticeConstruction1 {
    public static void main(String[] args) {
        new Person1();
        new Person1("参数");
    }
}
