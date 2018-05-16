package collectionDemo;

import java.util.HashSet;
import java.util.Set;

// 创建3个类
class A {
    // 覆盖 hashCode 方法
    @Override
    public int hashCode() {
        return 1;
    }
}
class B {
    // 覆盖 equals 方法
    @Override
    public boolean equals(Object obj) {
        return true;
    }
}
class C {
    // 同时覆盖 hashCode 方法和 equals 方法
    @Override
    public int hashCode() {
        return 2;
    }
    @Override
    public boolean equals(Object obj) {
        return true;
    }
}

public class HashSetDemo1 {

    public static void main(String[] args) {
        Set set = new HashSet();
        set.add(new A());
        set.add(new A());
        set.add(new B());
        set.add(new B());
        set.add(new C());
        set.add(new C());

        // 输出：5。 因为 A 类和 B 类并没有同时覆盖 hashCode 方法和 equals 方法，所以 HashSet 判断为不重复
        System.out.println(set.size());
        // 而 C 类同时覆盖了比较的两个方法，所以判断为重复，所以集合中只有1个 C 类对象
        System.out.println(set);
    }

}
