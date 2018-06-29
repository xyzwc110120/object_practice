package javaNewFeaturesDemo.java7NewFeaturesDemo;

// 二进制字面量
public class BinaryDemo {

    public static void main(String[] args) {
        byte b = 0b00000101;
        System.out.println(b);

        // 使用下划线对数值进行分隔表示
        short s = 0B00000000_00000101;
        System.out.println(s);

        int i = 0B00000000_00000000_00000000_00000101;
        System.out.println(i);

        /*
            编译后：
                byte b = 5;
                System.out.println(b);
                short s = 5;
                System.out.println(s);
                int i = 5;
                System.out.println(i);
        */
    }

}
