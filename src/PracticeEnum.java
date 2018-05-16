enum Week {
    // private Week() {}        枚举实例必须位于枚举类顶部
    MON, TUE, WED, THUR, FRI, SAT, SUN;

    // Week() {}                默认私有构造方法，即使不写访问权限也是private（假构造器，底层没有无参构造器）
    // 编译之后：private Week() {}

}

class PracticeEnum {

    private static void test(Week week) {
        // new Week();              枚举不能使用new关键字
        switch (week) {
            case MON :
                System.out.println("周一");
                break;
            case TUE :
                System.out.println("周二");
                break;
            case WED :
                System.out.println("周三");
                break;
            case THUR :
                System.out.println("周四");
                break;
            case FRI :
                System.out.println("周五");
                break;
            case SAT :
                System.out.println("周六");
                break;
            case SUN :
                System.out.println("周日");
                break;
        }
        /*
            // 反编译后，switch 底层其实是使用的枚举常量的序号
            switch (PracticeEnum.1.$SwitchMap$Week[week.ordinal()]) {
                case 1:
                  System.out.println("周一");
                  break;
                case 2:
                  System.out.println("周二");
                  break;
                case 3:
                  System.out.println("周三");
                  break;
                case 4:
                  System.out.println("周四");
                  break;
                case 5:
                  System.out.println("周五");
                  break;
                case 6:
                  System.out.println("周六");
                  break;
                case 7:
                  System.out.println("周日");
            }
        */
    }

    public static void main(String[] args) {
        test(Week.MON);

        // Enum 类中的方法
        // 返回枚举对象的常量名称
        System.out.println(Week.MON.name());
        // 返回枚举对象的序号，从0开始
        System.out.println(Week.SUN.ordinal());
        // 返回枚举对象的常量名称
        System.out.println(Week.FRI.toString());

        // 编译器生成的枚举类的静态方法
        // values()：返回枚举实例数组
        Week[] weeks = Week.values();
        for (Week week : weeks) {
            System.out.println(week.name());
        }
        // valueOf(String str)：获取指定名称字符串的当前枚举类中同名的常量
        System.out.println(Week.valueOf("SUN").name());
        // System.out.println(Week.valueOf("SUn").name());
        // 异常：test.lang.IllegalArgumentException: No enum constant Week.SUn
    }
}
