public class PracticeSingleton {

    public static void main(String[] args) {
        SingletonDemo1.getDemo1().opt();
        // SingletonDemo1.demo1.opt();

        // new SingletonDemo1();        无法重新实例化对象

        // 枚举单例（枚举中只有一个实例）
        SingletonDemo2.SINGLETON_ENUM.opt();
    }

}

// 单例模式（饿汉模式）
class SingletonDemo1 {

    // 现在类中自己创建一个对象
    private static SingletonDemo1 demo1 = new SingletonDemo1();
    // public static SingletonDemo1 demo1 = new SingletonDemo1();       直接将对象设置为公共的，则不需要写一个获取对象的公共静态方法供外界使用

    // 私有化自身构造器，防止外界通过构造器创建新的对象
    private SingletonDemo1() {
        System.out.println("私有化构造器");
    }

    static SingletonDemo1 getDemo1() {
        return demo1;
    }

    void opt() {             // 非静态方法，无法直接用类名调用，需要用对象调用
        System.out.println("非静态操作方法");
    }

}

// 枚举单例（）
enum SingletonDemo2 {
    SINGLETON_ENUM;

    void opt() {
        System.out.println("枚举单例");
    }
}
