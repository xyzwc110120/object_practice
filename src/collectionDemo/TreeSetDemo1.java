package collectionDemo;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

// 存入 TreeSet 集合中的元素，需要实现 Comparable（自然排序） 接口，实现接口中的 compareTo 方法来进行元素比较
class Person implements Comparable<Person> {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 覆盖 toString 方法
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    // 实现比较方法
    @Override
    public int compareTo(Person other) {
        if (this.age > other.age) {
            return 1;
        } else if (this.age < other.age) {
            return  -1;
        }
        return 0;
    }
}

// 定制排序，实现 Comparator 接口
class NameLengthComparator implements Comparator<Person> {

    // 实现 compare 方法，编写排序规则
    @Override
    public int compare(Person person1, Person person2) {
        // 通过名字长度类排序
        if (person1.name.length() > person2.name.length()) {
            return 1;
        } else if (person1.name.length() < person1.name.length()) {
            return -1;
        } else {
            // 若名字长度一直，则在按照年龄排序
            if (person1.age > person2.age) {
                return 1;
            } else if (person1.age < person2.age){
                return -1;
            }
            return 0;
        }
    }
}

public class TreeSetDemo1 {

    public static void main(String[] args) {
        Set<Person> set = new TreeSet<>();
        set.add(new Person("赵一", 18));
        set.add(new Person("钱二", 19));
        set.add(new Person("孙三", 19));  // 因为比较年龄返回为0，所以认为和“钱二”为同一个对象，所以不会存入集合
        set.add(new Person("李四", 20));
        System.out.println(set.size());
        System.out.println(set);

        // 传入定制比较器对象，这里也可以直接用匿名内部类
        Set<Person> set1 = new TreeSet<>(new NameLengthComparator());
        set1.add(new Person("1", 17));
        set1.add(new Person("23", 19));
        set1.add(new Person("62", 15));
        set1.add(new Person("921", 20));
        set1.add(new Person("4162", 14));
        System.out.println(set1);

    }

}
