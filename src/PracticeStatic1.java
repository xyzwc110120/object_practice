/**
 * Created by BM0010 on 2017/6/6.
 */
class Person2 {

    static String param = "类变量";

    static void method() {
        System.out.println("类方法：" + param);
    }

    void test() {
        System.out.println("类变量：" + param + "，实例变量：" + test);
    }

    String test = "实例变量";

}


public class PracticeStatic1 {
    public static void main(String[] args) {
        // static String param2 = "";       // 局部变量不能被声明为 static 变量。
        System.out.println("PracticeStatic1 类中主方法被加载");
        Person2.method();
        System.out.println("Person2.param == Person2.param：" + (Person2.param == Person2.param));
        new Person2().test();
    }
}
