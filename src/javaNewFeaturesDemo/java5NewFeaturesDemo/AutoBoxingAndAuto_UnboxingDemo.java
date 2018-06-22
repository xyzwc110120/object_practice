package javaNewFeaturesDemo.java5NewFeaturesDemo;

// 自动装箱与拆箱
public class AutoBoxingAndAuto_UnboxingDemo {

    public static void main(String[] args) {
        // 自动装箱与拆箱
        Integer var1 = 18;      // 编译后：Integer var1 = Integer.valueOf(18);
        int var2 = var1;        // 编译后：int var2 = var1.intValue();

        // 比较
        Integer num1 = new Integer(18);
        Integer num2 = new Integer(18);
        System.out.println(num1 == num2);   // false，== 比较的是内存地址，每次 new 都是开辟了一个新的内存空间
        System.out.println("--------------------------------------------");
        /*
        public static Integer valueOf(int i) {
            if (i >= IntegerCache.low && i <= IntegerCache.high)
                return IntegerCache.cache[i + (-IntegerCache.low)];
            return new Integer(i);
        }
        在 [-128, 127] 范围内，取得时常量池的中常量，所以两个对象表示的同一个对象
        */
        num1 = Integer.valueOf(18);
        num2 = Integer.valueOf(18);
        System.out.println(num1 == num2);   // true
        num1 = Integer.valueOf(200);
        num2 = Integer.valueOf(200);
        System.out.println(num1 == num2);   // false，因为超出了缓存范围，所以重新创建了对象
        System.out.println("--------------------------------------------");
        num1 = 18;
        num2 = 18;
        System.out.println(num1 == num2);   // true：因为编译后底层用的时 valueOf() 方法
        System.out.println("--------------------------------------------");
        num1 = 128;
        num2 = 128;
        System.out.println(num1.equals(num2));  // true：因为 Integer 类中重写了 equals 方法，比较的是值

    }

}
