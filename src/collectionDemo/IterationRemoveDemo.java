package collectionDemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// 迭代删除操作
public class IterationRemoveDemo {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        System.out.println("删除元素前：");
        System.out.println(list);
        System.out.println("-------------------------");

        // 在迭代中删除集合中的 C 元素
        for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
            String str = iterator.next();
            if ("C".equals(str)) {
                // 使用迭代器中的 remove 方法
                iterator.remove();
            }
        }
        System.out.println("删除元素后：");
        System.out.println(list);
    }
}
