package javaNewFeaturesDemo.java7NewFeaturesDemo;

// switch 语句操作 String
public class SwitchStringDemo {

    public static void main(String[] args) {
        String str = "A";
        switch (str) {
            case "A":
                break;
            case "B":
                break;
            case "C":
                break;
        }
        /*
            编译后：
                String str = "A";
                byte var3 = -1;
                switch(str.hashCode()) {
                case 65:
                    if (str.equals("A")) {
                        var3 = 0;
                    }
                    break;
                case 66:
                    if (str.equals("B")) {
                        var3 = 1;
                    }
                    break;
                case 67:
                    if (str.equals("C")) {
                        var3 = 2;
                    }
                }
            其实 switch 操作字符串是先通过 String对象.hashCode() 方法得到 int 类型的哈希码然后再来做操作。

            switch 可以操作的类型有：
                byte，short，char，int。
                Byte，Short，Character，Integer（因为 Java5 中的自动拆箱）
                枚举类型（通过 ordinal() 方法得到 int 类型的枚举常量的序数来做操作）
                String（通过 String对象.hashCode() 方法得到 int 类型的哈希码来做操作）

            可以说，switch 支支持整数类型。
        */
    }

}
