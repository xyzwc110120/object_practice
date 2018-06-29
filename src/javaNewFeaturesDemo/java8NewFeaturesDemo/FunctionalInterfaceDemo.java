package javaNewFeaturesDemo.java8NewFeaturesDemo;

// @FunctionalInterface 注解：可以检测接口是否为函数式接口，并且可以生成文档
@FunctionalInterface
interface MyWork {
    void doWork();

    // 函数接口中可以写 Object 类中的方法，但是只能有一个自身的抽象方法
    boolean equals(Object o);
    String toString();
}

// 函数式接口
public class FunctionalInterfaceDemo {

    public static void main(String[] args) {
        Work(() -> System.out.println("开始工作咯~"));
    }

    private static void Work(MyWork myWork) {
        System.out.println("上班了~");
        myWork.doWork();
    }

}
