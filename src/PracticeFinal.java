public class PracticeFinal {

    static final int num = 0;

    public static void main(String[] args) {
        // num = 1;          常量不可修改
        FinalDemo demo1 = new FinalDemo();
        FinalDemo.num = 1;
        final FinalDemo demo2 = new FinalDemo();    // 引用类型常量可以修改引用对象的内容，但是引用的地址不可以改变
        // demo2 = demo1;
    }
}

class FinalDemo {
    public static int num = 0;

    public FinalDemo() {
        System.out.println(num);
    }
}