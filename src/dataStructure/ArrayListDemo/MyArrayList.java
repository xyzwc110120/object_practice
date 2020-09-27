package dataStructure.ArrayListDemo;

import java.util.Arrays;

/*
 * 基于数组的列表（模拟 ArrayList）
 */
public class MyArrayList {

    // 存储任意类型的元素
    private Object[] elements = null;
    // 数组中存储了多少个元素
    private int size = 0;

    // 默认队列的初始容量
    private static final int DEFAULT_INITIAL_CAPACITY = 10;

    /**
     * 构造方法，若使用无参数的构造方法，则使用默认的容量创建数组
     */
    public MyArrayList() {
        this(DEFAULT_INITIAL_CAPACITY);
    }
    /**
     * 创建指定容量的数组
     *
     * @param initialCapacity 数组容量
     */
    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("容量不能为复数");
        }
        elements = new Object[initialCapacity];
    }

    /**
     * 添加新元素
     *
     * @param element 要添加的元素
     */
    public void add(Object element) {
        // 若数组容量已满，则进行扩容
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
        elements[size] = element;
        size++;
    }

    /**
     * 查询指定索引位置的元素
     *
     * @param index 指定索引位置
     */
    public Object getElementByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("索引越界");
        }
        return elements[index];
    }

    /**
     * 修改指定索引位置的元素
     *
     * @param index 指定索引位置
     * @param newElement 新的元素
     */
    public void updateElementByIndex(int index, Object newElement) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("索引越界");
        }
        elements[index] = newElement;
    }

    /**
     * 删除指定索引位置的元素
     *
     * @param index 指定索引位置
     */
    public void deleteElementByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("索引越界");
        }
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
    }

    /**
     * 数组列表字符串化
     */
    @Override
    public String toString() {
        if (elements == null) {
            return "null";
        }
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(size * 2 + 1);
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i == size - 1) {
                sb.append("]");
            } else {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    /**
     * 获取数组的元素个数
     *
     * @return 数组的元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断数组中元素个数是否为 0
     *
     * @return ture：元数个数为 0；false：元素个数不为 0
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 清空数组中的元素
     */
    public void clear() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
        size = 0;
    }
}
