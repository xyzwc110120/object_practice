public class PracticeSingleton {

    public static void main(String[] args) {
        SingletonDemo1.getInstance().opt();
        // SingletonDemo1.demo1.opt();

        // 无法重新实例化对象
        // new SingletonDemo1();

        SingletonDemo2.getInstance();
        SingletonDemo2BySynchronized.getInstance();

        // 枚举单例（枚举中只有一个实例）
        SingletonDemo3.SINGLETON_ENUM.opt();
    }

}


// 单例模式（饿汉模式）
class SingletonDemo1 {

    // 现在类中自己创建一个对象
    private static SingletonDemo1 instance = new SingletonDemo1();
    // 直接将对象设置为公共的，则不需要写一个获取对象的公共静态方法供外界使用
    // public static SingletonDemo1 demo1 = new SingletonDemo1();

    // 私有化自身构造器，防止外界通过构造器创建新的对象
    private SingletonDemo1() {
        System.out.println("私有化构造器");
    }

    // 创建一个公共静态方法来返回该实例
    public static SingletonDemo1 getInstance() {
        return instance;
    }

    void opt() {             // 非静态方法，无法直接用类名调用，需要用对象调用
        System.out.println("非静态操作方法");
    }

}



// 单例模式（懒汉式）
class SingletonDemo2 {

    // 加载时不会实例化，而是调用时才实例化
    private static SingletonDemo2 instance = null;

    private SingletonDemo2() {
    }

    // 创建一个公共静态方法来实例化并返回该实例
    public static SingletonDemo2 getInstance() {
        if (instance == null) {
            instance = new SingletonDemo2();
        }
        return instance;
    }
}


// 单例模式（懒汉式，加入 synchronized 关键字保证线程安全）
class SingletonDemo2BySynchronized {

    private static SingletonDemo2BySynchronized instance = null;

    private SingletonDemo2BySynchronized() {
    }

    // 加入 synchronized 保证线程安全
    public static synchronized SingletonDemo2BySynchronized getInstance() {
        if (instance == null) {
            instance = new SingletonDemo2BySynchronized();
        }
        return instance;
    }
}


// 单例模式（懒汉式，使用“双重检查加锁”机制）
class SingletonDemo2ByVolatile {

    private static volatile SingletonDemo2ByVolatile instance = null;

    private SingletonDemo2ByVolatile() {
    }

    public static SingletonDemo2ByVolatile getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo2ByVolatile.class) {
                if (instance == null) {
                    instance = new SingletonDemo2ByVolatile();
                }
            }
        }
        return instance;
    }
}


// 枚举单例（更安全，通过反射也不能实例化）
enum SingletonDemo3 {
    SINGLETON_ENUM;

    // 操作
    void opt() {
        System.out.println("枚举单例");
    }
}
