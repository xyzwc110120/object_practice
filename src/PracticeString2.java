public class PracticeString2 {

    /*
    * 说说下面String对象彼此之间是否相等
    */

    public static String getStr() {
        return "AB";
    }

    public static void main(String[] args) {
        String str1 = "ABCD";
        String str2 = "A" + "B" + "C" + "D";
        String str3 = "AB" + "CD";
        String str4 = new String("ABCD");
        String temp = "AB";
        String str5 = temp + "CD";
        String str6 = getStr() + "CD";

        System.out.println("str1 == str2:" + (str1 == str2));       // true
        System.out.println("str1 == str3:" + (str1 == str3));       // true
        System.out.println("str1 == str4:" + (str1 == str4));       // false
        System.out.println("str1 == str5:" + (str1 == str5));       // false
        System.out.println("str1 == str6:" + (str1 == str6));       // false
        System.out.println("str5 == str6:" + (str5 == str6));       // false
    }
}
