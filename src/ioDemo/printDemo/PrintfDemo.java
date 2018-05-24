package ioDemo.printDemo;

// Java 的格式化输出
public class PrintfDemo {

    public static void main(String[] args) {
        String name = "哦呀呀呀";
        int age = 18;
        /*
        public final static PrintStream out = null;:
                out 是 System 类中 PrintStream 类型的静态常量，所以其实是调用的 PrintStream 类中的打印方法
        */
        System.out.println("姓名：" + name + "；年龄：" + age + "。");

        // 占位符：'d'：整数； 'f'：浮点； 's'：字符串。
        String format = "姓名：%s；年龄：%d。";
        Object[] data = {name, age};
        System.out.printf(format, data);
        System.out.println();

        System.out.printf("姓名：%s；年龄：%d。", "大哥哥", 28);
        System.out.println();
    }

}
