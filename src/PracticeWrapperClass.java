import java.util.ArrayList;
import java.util.List;

public class PracticeWrapperClass {

    public static void main(String[] args) {
        Integer a = 1;
        // 编译后：Integer a = Integer.valueOf(1);
        int b = a;
        // 编译后：int b = a.intValue();
        System.out.println(a);
        System.out.println(b);
        // 自动装 / 拆箱其实是在底层手动装 / 拆箱（见编译后文件：PracticeWrapperClass.class）

        // List<int> list = new ArrayList<>();      在Java集合框架中，只能存储对象，不能存储基本类型值
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        /*
        * 编译后（自动装箱）：
        *       list.add(Integer.valueOf(1));
        *       list.add(Integer.valueOf(2));
        */

        Integer x = 1;
        String y = "2";
        Object[] obj = {x, y};
    }

}
