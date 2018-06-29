package javaNewFeaturesDemo.java5NewFeaturesDemo;

enum Month {
    JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEPT, OCT, NOV, DEC
}
/*
编译后：
    final class Month extends Enum {

        public static final Month JAN;
        public static final Month FEB;
        public static final Month MAR;
        public static final Month APR;
        public static final Month MAY;
        public static final Month JUN;
        public static final Month JUL;
        public static final Month AUG;
        public static final Month SEPT;
        public static final Month OCT;
        public static final Month NOV;
        public static final Month DEC;
        private static final Month $VALUES[];

        // 在 API 中没有此方法，此方法是在编译后生成的，以数组方式返回枚举类的所有实例
        public static Month[] values() {
            return (Month[])$VALUES.clone();
        }

        // 在 API 中没有此方法，此方法也是在编译后生成的，其实底层调用的父类 Enum 类的 valueOf(Class<T> enumType, String name)方法                                         String name)
        // 返回带指定名称的该枚举类型的枚举实例。名称必须与在此类型中声明枚举常量所用的标识符完全匹配。
        // （不允许使用额外的空白字符并且区分大小写）
        public static Month valueOf(String name) {
            return (Month)Enum.valueOf(javaNewFeaturesDemo/java5NewFeaturesDemo/Month, name);
        }

        // 使用父类 Enum 类中的构造方法：protected Enum(String name, int ordinal)
        private Month(String s, int i) {
            super(s, i);
        }

        // 通过静态代码块创建枚举实例
        static {
            // 创建枚举实例，实例中的序数从 0 开始
            JAN = new Month("JAN", 0);
            FEB = new Month("FEB", 1);
            MAR = new Month("MAR", 2);
            APR = new Month("APR", 3);
            MAY = new Month("MAY", 4);
            JUN = new Month("JUN", 5);
            JUL = new Month("JUL", 6);
            AUG = new Month("AUG", 7);
            SEPT = new Month("SEPT", 8);
            OCT = new Month("OCT", 9);
            NOV = new Month("NOV", 10);
            DEC = new Month("DEC", 11);
            $VALUES = (new Month[] {
                JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEPT, OCT, NOV, DEC
            });
        }
    }
*/

// 枚举的细节
public class EnumDetailsDemo {

    public static void main(String[] args) {
        // 枚举类不能被实例化，就算使用反射也不行，很安全
        // new Month();
        // 获取枚举中所有实例
        Month[] months = Month.values();
        for (Month month: months) {
            /*
            Enum 类中的两个方法：
                public final String name()：
                    返回此枚举常量的名称，在其枚举声明中对其进行声明。
                    与此方法相比，大多数程序员应该优先考虑使用 toString() 方法，因为 toString 方法返回更加用户友好的名称
                public final int ordinal()：
                    返回枚举常量的序数（它在枚举声明中的位置，其中初始常量序数为零）
            */
            System.out.println(month.name() + " - " + month.ordinal());
        }
        System.out.println("--------------------------------------");

        // 返回带指定名称的该枚举类型的枚举实例。名称必须与在此类型中声明枚举常量所用的标识符完全匹配。
        // （不允许使用额外的空白字符并且区分大小写。）
        // Month JAN = Month.valueOf("JAn");
        Month JAN = Month.valueOf("JAN");
        System.out.println(JAN.toString());
        System.out.println("--------------------------------------");

        // switch 操作枚举
        /*
            编译后：
                switch (1..SwitchMap.javaNewFeaturesDemo.java5NewFeaturesDemo.Month[Month.APR.ordinal()])：
                其实 switch 操作枚举是通过 枚举实例.ordinal() 方法获得枚举常量的序数来比较的
        */
        switch (Month.APR) {
            // 在 switch 中的 case 中不能使用 类名.枚举常量 ，而是直接使用枚举常量
            // case Month.JAN :
            case JAN :
            case MAR :
            case MAY :
            case JUL :
            case AUG :
            case OCT :
            case DEC :
                System.out.println("这个月有31天");
                break;
            case FEB:
                System.out.println("这个月有28天");
                break;
            default :
                System.out.println("这个月有30天");
        }

        // 在 Java7 中，枚举可以操作字符串，原理就是通过 字符串对象.hashCode() 方法获得字符串的哈希码，然后比较哈希码。
        // 进行switch的实际是哈希值，然后通过使用equals方法比较进行安全检查，这个检查是必要的，因为哈希可能会发生碰撞。
        // （ hashCode() 方法返回的是 int 类型）
        switch ("A") {
            case "A" :
                break;
            case "B" :
                break;
            case "C" :
                break;
            default:
        }
        /*
            编译后：
                String s = "A";
                byte byte0 = -1;
                switch (s.hashCode()) {
                case 65: // 'A'
                    if (s.equals("A"))
                        byte0 = 0;
                    break;
                case 66: // 'B'
                    if (s.equals("B"))
                        byte0 = 1;
                    break;
                case 67: // 'C'
                    if (s.equals("C"))
                        byte0 = 2;
                    break;
                }
        */
        /*
            其实可以发现：
                swich只支持一种数据类型，那就是整型，其他数据类型都是转换成整型之后在使用switch的。
        */
    }
}
