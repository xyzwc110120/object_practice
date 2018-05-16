public class PracticeTemplateMethod {

    public static void main(String[] args) {
        System.out.println("String：" + new StringOperate().getOperateTime());
        System.out.println("StringBuilder：" + new StringBuilderOperate().getOperateTime());
        System.out.println("StringBuffer：" + new StringBufferOperate().getOperateTime());
    }

}

// 计算方法执行所化时间
abstract class AbstractOperateTimeTemplate {

    // 使用 final 修饰符使子类无法修改
    final public Long getOperateTime() {
        long startTime = System.currentTimeMillis();    // 开始时间（毫秒数）
        // 需要计算运行时间的方法
        this.doWork();              // 回调，其实调用的是子类中对抽象类完善的方法
        long endTime = System.currentTimeMillis();      // 结束时间（毫秒数）
        // 返回时间差
        return endTime - startTime;
    }

    // 抽象方法（由子类完成功能），使用 protected 访问修饰符让此抽象方法只能被子类使用，外界无法调用
    abstract protected void doWork();

}

// String 循环连接10000次
class StringOperate extends AbstractOperateTimeTemplate {

    @Override
    protected void doWork() {           // 回掉方法（钩子方法）：钩子方法的命名应当以 do 开始，如 HttpServlet 中的 doGet()、doPost() 方法
        String str = "";
        for (int i = 0; i < 10000; i++) {
            str += i;
        }
    }
}

// StringBuilder 循环连接10000次
class StringBuilderOperate extends AbstractOperateTimeTemplate {

    @Override
    protected void doWork() {
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            strBuilder.append(i);
        }
    }
}

class StringBufferOperate extends AbstractOperateTimeTemplate{

    @Override
    protected void doWork() {
        StringBuffer strBuffer = new StringBuffer();
        for (int i = 0; i < 10000; i ++) {
            strBuffer.append(i);
        }
    }
}
