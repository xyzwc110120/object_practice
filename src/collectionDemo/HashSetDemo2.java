package collectionDemo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Student {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // 通过 idea 快捷点 Ctrl + Insert 创建 hashCode 方法和 equals 方法，根据 id 和 name 来判断对象是否重复
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                Objects.equals(name, student.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
    // 覆盖 toString 方法
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class HashSetDemo2 {

    public static void main(String[] args) {
        Set<Student> set = new HashSet<>();
        set.add(new Student(1, "李狗蛋", 18));
        set.add(new Student(1, "王春燕", 17));
        set.add(new Student(2, "李狗蛋", 18));
        set.add(new Student(2, "李狗蛋", 17));
        set.add(new Student(2, "王春燕", 18));

        // 输出：4。 因为插入的对象没有同时满足 id 和 name 相等，所以 HashSet 集合认为是不同元素
        System.out.println(set.size());
        System.out.println(set);
    }
}
