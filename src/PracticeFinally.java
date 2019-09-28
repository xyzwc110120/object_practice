import java.util.HashMap;
import java.util.Map;

public class PracticeFinally {
    public static void main(String[] args) {
        System.out.println(finallyDemo1());
        System.out.println(finallyDemo2().get("key"));
    }

    private static int finallyDemo1() {
        int a = 1;
        try {
            return a;
        } finally {
            // 此语句会执行，但是返回的是 catch 中的值
            // ++a;
            // 如果 finally 语句块中有 return 语句，则永远返回 finally 中的结果
            return ++a;
        }
    }

    private static Map<String, String> finallyDemo2() {
        Map<String, String> map = new HashMap<>();
        try {
            map.put("key", "try");
            // return map.get("key").toString();        // 打印结果为：try（因为保留的是字符串）
            return map;                 // 打印结果为：finally（因为保留的是 map 对象）
        } finally {
            map.put("key", "finally");
            map = null;                 // 打印结果仍为：finally（因为 return 保留的是值，是 map 中的引用的值，也就是堆内存地址）
        }
    }
}
