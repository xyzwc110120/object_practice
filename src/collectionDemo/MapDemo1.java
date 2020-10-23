package collectionDemo;

import java.util.Map;
import java.util.TreeMap;

// 需求：计算一个字符串中，每一个字符出现的次数
public class MapDemo1 {

    public static void main(String[] args) {
        String str = "kiduannenzpvnwalkjdnfjsahpouewjnxchsdfhdauasdkfadfewnukfp";
        // 先将字符串转为 char[]
        char[] chars = str.toCharArray();
        // 实例化一个 Map 集合，key 用来存储出现过的字符，value 用来存储字符出现过的次数
        Map<Character, Integer> map = new TreeMap<>();      // 自然排序
        for (char c : chars) {
            // 如果 map 中不存在该字符 c 则向 map 中存入字符 c 并存入字符出现次数 1。
            // 如果 map 中存在字符 c 则获取字符已出现的次数 value 并 +1。
            map.put(c, (map.containsKey(c) ? map.get(c) + 1 : 1));
        }
        System.out.println(map);
    }
}
