public class PracticeWrapperClassCache {

    public static void main(String[] args) {

        Integer i1 = new Integer(123);
        Integer i2 = new Integer(123);
        System.out.println("i1 = i2 : " + (i1 == i2));          // false


        Integer i3 = Integer.valueOf(123);
        Integer i4 = Integer.valueOf(123);
        Integer i5 = Integer.valueOf(250);
        Integer i6 = Integer.valueOf(250);
        /*
            Integer 类中的 valueOf 方法：
                public static Integer valueOf(int i) {
                    if (i >= IntegerCache.low && i <= IntegerCache.high) {
                        return IntegerCache.cache[i + (-IntegerCache.low)];
                    }
                    return new Integer(i);
                }
            如果传入的数据的值在 [-128, 127] 之间的话，则取缓存中的数据，所以其实指向的就是同一内存地址，
            否则则会重新 new 一个 Integer 对象。
        */
        System.out.println("i3 = i4 : " + (i3 == i4));          // true
        System.out.println("i5 = i6 : " + (i5 == i6));          // false
        /*
            Integer 类中的 equal 方法（重写 Object 类中的 equal 方法）：
                public boolean equals(Object obj) {
                    if (obj instanceof Integer) {
                        return value == ((Integer)obj).intValue();
                    }
                    return false;
                }
            把包装类型拆箱为基本类型进行比较，只比较数据的值
        */
        System.out.println("i5.equal(i6)：" + i5.equals(i6));   // true


        Integer i7 = 123;
        // 在底层编译后就是：Integer i7 = Integer.valueOf(123);
        Integer i8 = 123;
        System.out.println("i5 = i6 : " + (i7 == i8));          // true

    }

}
