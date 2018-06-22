package reflectDemo.simpleApplicationDemo;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayDemo {

    public static void main(String[] args) {
        // java.lang.reflect.Array：Array 类提供了动态创建和访问 Java 数组的方法
        Object arr = Array.newInstance(int.class, 5);
        Array.set(arr, 2, 5);
        // Object val = Array.get(arr, 2);
        int val = Array.getInt(arr, 2);
        System.out.println(val);
        System.out.println("----------------------------");

        // 数组复制
        int[] arrSrc = new int[]{1, 2, 3, 4, 5, 6};
        int[] arrDest = new int[6];
        System.out.println(Arrays.toString(arrDest));
        arraycopy(arrSrc, 2, arrDest, 3, 2);
        System.out.println(Arrays.toString(arrDest));
    }

    /**
     * 数组拷贝
     *
     * @param src 源数组
     * @param srcPos 源数组中起始位置（从源数组中哪个位置开始复制）
     * @param dest 目标数组
     * @param destPos 目标数据中的其实位置（从目标数组中哪个位置开始粘贴）
     * @param length 要复制的数组元素的数量
     */
    private static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length) {
        if (src == null || dest == null) {
            throw new NullPointerException("源数组或目标数组不可为空！！！");
        }
        if (!src.getClass().isArray() || !dest.getClass().isArray()) {
            throw new ArrayStoreException("源对象和目标对象都必须为数组！！！");
        }
        if (srcPos < 0 || destPos < 0 || length < 0 || srcPos + length > Array.getLength(src) || destPos + length > Array.getLength(dest)) {
            throw new ArrayIndexOutOfBoundsException("数组下标越界");
        }
        for (int index = srcPos; index < srcPos + length; index++) {
            // 获取源数组中特定索引位置的值
            Object srcVal = Array.get(src, index);
            // 将需要复制的值放入目标数组的特定索引位置
            Array.set(dest, destPos, srcVal);
            destPos++;
        }
    }

}
