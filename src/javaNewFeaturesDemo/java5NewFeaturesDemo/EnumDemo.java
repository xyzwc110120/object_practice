package javaNewFeaturesDemo.java5NewFeaturesDemo;

// 在 Worker 类中定义一个字段，用来表示在哪一天休息（星期几）
// 使用 Integer 类型表示休息日
class Worker1 {
    /*
        使用 Integer 类型来表示星期几：
            1)：业务含义不明确，1 不一定表示周一，也可能表示周日
            2)：类型不安全，可以给 Integer 随便设置整数值
    */
    private Integer restDay;        // 休息日（周一到周日）

    public Integer getRestDay() {
        return restDay;
    }

    public void setRestDay(Integer restDay) {
        this.restDay = restDay;
    }
}

// 使用 WeekDay2 类型表示休息日
class Worker2 {
    private WeekDay2 restDay;

    public WeekDay2 getRestDay() {
        return restDay;
    }

    public void setRestDay(WeekDay2 restDay) {
        this.restDay = restDay;
    }
}

// 使用枚举 WeekDay 表示休息日
class Worker {
    private WeekDay restDay;

    public WeekDay getRestDay() {
        return restDay;
    }

    public void setRestDay(WeekDay restDay) {
        this.restDay = restDay;
    }
}



// 解决方案1：定义 WeekDay1 的常量类，封装了周一到周日的常量值
class WeekDay1 {
    // 此时，虽然业务含义明确，但是依然存在类型不安全的问题，依然可以随意设置一个 Integer 类型的值
    public static final Integer MON = 1;
    public static final Integer TUE = 2;
    public static final Integer WEN = 3;
    public static final Integer THU = 4;
    public static final Integer FRI = 5;
    public static final Integer STA = 6;
    public static final Integer SUN = 7;
}

// 解决方案2：模拟枚举，定义一个 WeekDay2 类，来表示星期几
class WeekDay2 {
    // 虽然解决了业务不明确和类型不安全的问题，但是代码太过繁琐
    public static final WeekDay2 MON = new WeekDay2();
    public static final WeekDay2 TUE = new WeekDay2();
    public static final WeekDay2 WEN = new WeekDay2();
    public static final WeekDay2 THU = new WeekDay2();
    public static final WeekDay2 FRI = new WeekDay2();
    public static final WeekDay2 STA = new WeekDay2();
    public static final WeekDay2 SUN = new WeekDay2();

    // 私有化构造器，防止外界外界创建新的构造器
    private WeekDay2() { }
}

// 解决方案3：为了解决方案2的代码繁琐问题，从 Java5 开始推出枚举类型
enum WeekDay {
    // 其实，枚举类 WeekDay 底层就是解决方案2中的 WeekDay2 类
    MON, TUE, WEN, THU, FRI, STA, SUN;
}



// 为什么需要使用枚举
public class EnumDemo {

    public static void main(String[] args) {
        // 解决方案1：
        Worker1 worker1 = new Worker1();
        worker1.setRestDay(WeekDay1.FRI);
        // 此时，虽然业务含义明确，但是依然存在类型不安全的问题，依然可以随意设置一个 Integer 类型的值
        // worker.setRestDay(15);
        if (worker1.getRestDay() == WeekDay1.STA || worker1.getRestDay() == WeekDay1.SUN) {
            System.out.println("周末休息");
        } else {
            System.out.println("周一至周五休息");
        }
        System.out.println("-------------------------------------");


        // 解决方案2：
        Worker2 worker2 = new Worker2();
        // 私有化构造器，防止外界创建新的 WeekDay 对象
        // worker2.setRestDay(new WeekDay2());
        worker2.setRestDay(WeekDay2.FRI);
        if (worker2.getRestDay() == WeekDay2.STA || worker2.getRestDay() == WeekDay2.SUN) {
            System.out.println("周末休息");
        } else {
            System.out.println("周一至周五休息");
        }
        System.out.println("-------------------------------------");


        // 解决方案3：
        Worker worker = new Worker();
        worker.setRestDay(WeekDay.FRI);
        if (worker.getRestDay() == WeekDay.STA || worker.getRestDay() == WeekDay.SUN) {
            System.out.println("周末休息");
        } else {
            System.out.println("周一至周五休息");
        }
    }

}
