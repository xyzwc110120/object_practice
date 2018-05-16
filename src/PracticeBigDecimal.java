import java.math.BigDecimal;

public class PracticeBigDecimal {

    public static void main(String[] args) {
        /*
         * public BigDecimal(double val)：
         *       此构造方法的结果有一定的不可预知性。有人可能认为在 Java 中写入 new BigDecimal(0.1) 所创建的 BigDecimal 正好等于 0.1
         *（非标度值 1，其标度为 1），但是它实际上等于 0.1000000000000000055511151231257827021181583404541015625。
         * 这是因为 0.1 无法准确地表示为 double（或者说对于该情况，不能表示为任何有限长度的二进制小数）。
         * 这样，传入 到构造方法的值不会正好等于 0.1（虽然表面上等于该值）。
         *       另一方面，String 构造方法是完全可预知的：写入 new BigDecimal("0.1") 将创建一个 BigDecimal，它正好 等于预期的 0.1。
         * 因此，比较而言，通常建议优先使用 String 构造方法。
         *       当 double 必须用作 BigDecimal 的源时，请注意，此构造方法提供了一个准确转换；
         * 它不提供与以下操作相同的结果：先使用 Double.toString(double) 方法，然后使用 BigDecimal(String) 构造方法，将 double 转换为 String。
         * 要获取该结果，请使用 static valueOf(double) 方法。
         * */
        double dou = 0.1;
        System.out.println(dou + 0.33);
        System.out.println(new BigDecimal(0.1).add(new BigDecimal(0.33)));
        System.out.println(new BigDecimal("0.1").add(new BigDecimal("0.33")));
        System.out.println(new BigDecimal(Double.valueOf(dou).toString()).add(new BigDecimal("0.33")));
    }

}
