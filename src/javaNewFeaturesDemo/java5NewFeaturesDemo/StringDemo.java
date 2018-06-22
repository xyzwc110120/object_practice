package javaNewFeaturesDemo.java5NewFeaturesDemo;

// 使用分隔符连接字符串
public class StringDemo {

    public static void main(String[] args) {
        System.out.println(StringUtil.join("-", "A", "B", "C", "D"));
        System.out.println(StringUtil.join(null, "A", "B", "C", "D"));
        System.out.println("-----------------------------");

        String str = null;
        // 字符串与常量比较，常量要放在前面，因为如果字符串为 null 的话会出现空指针异常
        // System.out.println(str.equals(""));     // java.lang.NullPointerException
        System.out.println("".equals(str));
        // 判断是否为空要放在前面，不然会出现空指针异常
        // System.out.println("".equals(str.trim()) || str == null);       // java.lang.NullPointerException
        System.out.println(str == null || "".equals(str.trim()));
        System.out.println("-----------------------------");

        // java 1.8 中 String 类中新增了一个 join 方法
        System.out.println(String.join("-", "A", "B", "C", "D"));
    }

}
