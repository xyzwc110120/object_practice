/**
 * Created by BM0010 on 2017/7/13.
 */
class Person3 {
    private String name;
    private int age;

    Person3(String name) {
        this.name = name;
    }

    Person3(String name, int age) {
        // System.out.println("在构造器互调之前执行");

        // 构造器重载互调， this([参数]) 必须写在构造器方法第一行且只能使用一次
        this(name);
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class PracticeThis1 {

    public static void main(String[] args) {
        // Person3 person = new Person3();     // 若显示提供构造器，则编译器则不再创建缺省构造器
        Person3 person3 = new Person3("HaHa", 18);
        System.out.println(person3.getName() + "，" + person3.getAge());
    }

}
