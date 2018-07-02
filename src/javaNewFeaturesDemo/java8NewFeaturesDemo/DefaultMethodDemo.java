package javaNewFeaturesDemo.java8NewFeaturesDemo;

// 动物类
class Animal {
    public void run() {
        System.out.println("动物在奔跑");
    }
    public void eat() {
        System.out.println("动物吃东西");
    }
}
// 猫接口
interface Cat {
    void fish();
    void run();

    default void eat() {
        System.out.println("猫吃鱼");
    }
    default void sleep() {
        System.out.println("猫要睡觉");
    }
    static void play() {
        System.out.println("猫玩毛线球");
    }
}
// 狗接口
interface Dog {
    void bone();
    void run();

    default void eat() {
        System.out.println("狗吃骨头");
    }
    default void sleep() {
        System.out.println("狗要睡觉");
    }
    static void play() {
        System.out.println("狗玩飞盘");
    }
}

// 默认方法
public class DefaultMethodDemo extends Animal implements Cat, Dog {

    @Override
    public void fish() {
        System.out.println("猫最喜欢鱼");
    }

    @Override
    public void bone() {
        System.out.println("狗最喜欢骨头");
    }

    // 因为实现的两个接口拥有相同方法签名的默认方法，所以在实现类中要重写
    @Override
    public void sleep() {
        // 如果想要复用某个接口中冲突的那个默认方法：接口名.super.方法名(方法列表);
        Dog.super.sleep();
    }

    public static void main(String[] args) {
        // 接口中的静态方法，可以直接用类名调用
        Dog.play();
        Cat.play();
    }

    public void test() {
        // 若父类中有方法与接口中的抽象方法方法签名一致，则使用的时父类的方法
        run();
        // 若父类中有方法与接口中的默认方法方法签名一直，也是使用的父类的方法
        // （也就是说，接口中的默认方法无法覆盖父类中的方法）
        eat();
    }

}
