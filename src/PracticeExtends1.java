/**
 * Created by BM0010 on 2017/7/14.
 */
class Person4 {

    private String name;
    private int age;

    Person4() {
        System.out.println("父类无参构造方法");
    }

    Person4(int age) {
        this.age = age;
        System.out.println("父类带参构造方法");
    }

    public void sleep() {
        System.out.println("该睡觉了");
    }

    public int getAge() {
        return age;
    }

}

class Student extends Person4 {
    private String name;      // 姓名

    // 子类带参构造方法
    Student(String name) {          // 默认先调用父类无参构造方法
        this.name = name;
        System.out.println("这是子类构造方法");
    }

    // 方法覆写
    @Override       // 方法覆写注解
    public void sleep() {
        System.out.println(name + "作业还没做完");
    }
}

class Teacher extends Person4 {
    String subject;     // 所教科目

    Teacher(int age) {
        // System.out.println("报错");        // 显示调用父类构造方法必须放在子类构造方法第一句
        super(age);             // 显示调用父类构造方法
        System.out.println("老师今年" + super.getAge());
    }

    // @Override        该方法不为覆写方法，所以使用覆写注解会报错，所以，可以用覆写注解来判断一个方法是不是覆写方法
    public void teach() {
        System.out.println("老师教书");
    }
}

public class PracticeExtends1 {
    public static void main(String[] args) {
        new Teacher(24).sleep();
        new Student("小明").sleep();
    }
}