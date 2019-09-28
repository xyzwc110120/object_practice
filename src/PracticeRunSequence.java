/*
    父类静态块           PracticeRunSequence类依赖于subClass类，所以得先把subClass类的字节码加载进JVM
    子类静态块
    父类构造方法
    子类构造方法
    练习类构造函数
    练习类静态块
    练习类主方法
*/



public class PracticeRunSequence {

    private static PracticeRunSequence sequence = new PracticeRunSequence();
    private SubClass subClass = new SubClass();         // 非static字段的初始化其实都是在构造其中，优先执行的
    // private SubClass subClass = null;                // 例子

    static {
        System.out.println("练习类静态块");
    }

    private PracticeRunSequence() {
        // subClass = new SubClass();                   // 应用类的初始化其实在构造其中优先执行
        System.out.println("练习类构造函数");
    }

    public static void main(String[] args) {
        System.out.println("练习类主方法");
    }
}


class SuperClass {
    static {
        System.out.println("父类静态块");
    }

    SuperClass() {
        System.out.println("父类构造方法");
    }
}


class SubClass extends SuperClass {
    static {
        System.out.println("子类静态块");
    }

    SubClass() {
        System.out.println("子类构造方法");
    }
}
