package genericType;

import java.util.ArrayList;
import java.util.List;

public class GenericDemo {

    public static void main(String[] args) {
        Point<Double> point = new Point<>();
        point.setX(24.14);
        Double x = point.getX();
        /*
            编译后：
            Point<Double> point = new Point();
            point.setX(Double.valueOf(24.14D));
            Double x = (Double)point.getX();

            可以发现，泛型其实也是语法糖，底层依然没有泛型，而且依然使用了强转
        */


        List<Integer> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<Number> list3 = new ArrayList<>();
        List<Object> list4 = new ArrayList<>();

        upperLimit(list1);
        // upperLimit(list2);   String 类并不是 Number 类的子类
        upperLimit(list3);
        // upperLimit(list4);   Object 类并不是 Number 类的子类

        // lowerLimit(list1);   Integer 类并不是 Number 类的父类
        // lowerLimit(list2);   String 类并不是 Number 类的父类
        lowerLimit(list3);
        lowerLimit(list4);
    }

    // 泛型的上限：此时的泛型 ? ，必须是 Number 类型或 Number 类的子类，这里设置了上限为 Number 类。
    private static void upperLimit(List<? extends Number> list) {
        list = new ArrayList<>();
        // list.add(1);     使用泛型通配符的集合只能接受数据，无法存储数据，因为不知道该存储什么样的数据类型
    }
    // 泛型的下限：此时的泛型 ? ，必须是 Number 类型或 Number 类的父类，这里设置了下限为 Number 类。
    private static void lowerLimit(List<? super Number> list) {
    }

}
