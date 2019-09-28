public class PracticeInterface {

    public static void main(String[] args) {
        System.out.println("接口练习");
    }
}


interface InterfaceDemo {       // 编译成功后和类一样会单独生成一个 .class 文件的字节码

    // 成员变量
    String str = "";
    /*
        接口中的成员变量默认使用 public static final 修饰
        编译后：public static final String str = "";
    */

    // 抽象方法
    void interfaceHandler();
    /*
        接口中的方法都是公共的抽象方法，默认使用 public abstract 来修饰
        编译后：public abstract void interfaceHandler();
    */

    // 内部接口
    interface innerInterface{}
    /*
        接口中定义的内部类/接口都是公共静态的，默认使用 public static 来修饰
        编译后：public static interface innerInterface {}
    */
}
