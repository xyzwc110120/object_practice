/**
 * Created by BM0010 on 2017/6/6.
 */
class Person1 {
    Person1() {
        System.out.println("Person1()：无参自定义构造方法");
    }

    Person1(String name) {
        System.out.println("Person1(String name)：有参自定义构造方法：" + name);
    }
}

/*
* 一个源文件中只能有一个public类
* 一个源文件可以有多个非public类
* public类的类名应该和源文件的名称保持一致
* */
public class PracticeConstruction1 {
    public static void main(String[] args) {
        new Person1();
        new Person1("参数");
    }
}
