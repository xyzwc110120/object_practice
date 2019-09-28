/**
 * Created by BM0010 on 2017/6/4.
 */
public class PracticeString1 {

    public static void main(String[] args) {
        String str1 = "abc";
        System.out.println("str1：" + str1);

        String str2 = str1;
        System.out.println("str2：" + str2);
        System.out.println("str1 == str2：" + (str1 == str2));

        str2 = "abc";
        System.out.println("str2：" + str2);
        System.out.println("str1：" + str1);
        // String有个常量池，str1 == str2是返回true的，就是因为常量池的原因，实际上a和b是同一个对象。
        System.out.println("str1 == str2：" + (str1 == str2));

        str2 = new String("abc");
        System.out.println("str2：" + str2);
        System.out.println("str1：" + str1);
        // 这样str1 == str2就是返回false了，str1和str2不是同一个对象
        System.out.println("str1 == str2：" + (str1 == str2));
    }
}
