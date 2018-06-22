package javaNewFeaturesDemo.java5NewFeaturesDemo;

// 字符串工具类
public class StringUtil {

    // 私有化构造器
    private StringUtil() {

    }

    /**
     * 判断字符串是否为空（1引用为空：null； 2空字符串：""）
     *
     * @param str 需要判断的字符串
     * @return true：为空； false：不为空
     */
    public static boolean isBlank(String str) {
        return str == null || "".equals(str.trim());
    }

    /**
     * 判断字符串是否不为空
     *
     * @param str 需要判断的字符串
     * @return true：为空； false：不为空
     */
    public static boolean isNotBlank(String str) {
        // 对判断字符串是否为空的方法 isBlank 取反
        return !isBlank(str);
    }

    /**
     * 定义一个方法：join() ，可以对传入该方法的字符串按照指定的分隔符做连接，并返回连接好的新字符串
     *
     * @param separator 指定的分隔符
     * @param values 需要连接的字符串
     * @return 连接好的新字符串
     */
    public static String join(String separator, String... values) {
        // 若分隔符为空，则给一个默认分隔符
        // public String trim()：返回字符串的副本，忽略前导空白和尾部空白
        if (isBlank(separator)) {
            separator = ",";
        }
        // 因为 StringBuilder 默认为 16 个长度的字符数组，所以为了防止数组内存的浪费或的扩容操作，一开始就设置好长度
        StringBuilder builder = new StringBuilder(values.length * 2 - 1);
        for (int i = 0; i < values.length; i++) {
            builder.append(values[i]);
            // 若连接的字符为最后一个，则不在后面加上分隔符
            if (i != values.length - 1) {
                builder.append(separator);
            }
        }
        return builder.toString();
    }

}
