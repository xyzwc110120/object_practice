package dataStructure.linkedListDemo;

// 双向链表集合（模拟）
public class MyLinkedList {

    // 链表中的每一个节点
    class Node {
        Node prev;      // 上一个节点对象
        Node next;      // 下一个节点对象
        Object ele;     // 当前节点中存储的数据

        // 构造方法，创建一个新节点，将数据存储至当前节点
        public Node(Object ele) {
            this.ele = ele;
        }
    }

    // 链表中第一个节点
    private Node first;
    // 链表中最后一个节点
    private Node last;
    // 链表中节点数量
    private int size = 0;

    /**
     * 重写 Object类 中 toString()方法
     *
     * @return 链表
     */
    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        // 将链表进行字符串拼接
        StringBuilder sb = new StringBuilder();
        Node current = this.first;      // 获取链表第一个节点
        sb.append("[");
        // 遍历链表，若当前节点不为 null，则继续循环
        while (current != null) {
            sb.append(current.ele);
            if (current.next != null) {
                sb.append(", ");            // 若节点不为链表最后一个，则添加“, ”符号
            } else {
                sb.append("]");             // 若结点为链表最后一个，则添加“]”符号
            }
            current = current.next;     // 获取当前节点的下一个节点
        }
        return sb.toString();
    }

    /**
     * 向链表头部添加节点
     *
     * @param ele 节点内需要存储的数据
     */
    public void addFirst(Object ele) {
        // 新建一个需要保存的节点对象
        Node node = new Node(ele);
        if (this.size == 0) {       // 如果链表中没有节点
            this.last = node;           // 将新增节点设为链表最后一个节点
        } else {
            this.first.prev = node;     // 将现链表中第一个节点中的上一节点设为新增节点
            node.next = this.first;     // 将现链表中第一个节点设为新增节点中的下一个节点
        }
        this.first = node;  // 将新增节点设为链表中第一个节点
        this.size++;        // 增加链表节点数量
    }

    /**
     * 向链表尾部添加节点
     *
     * @param ele 节点内需要存储的数据
     */
    public void addLast(Object ele) {
        // 新建一个需要保存的节点对象
        Node node = new Node(ele);
        if (this.size == 0) {       // 如果链表中没有节点
            this.first = node;          // 将新增节点设为链表第一个节点
        } else {
            this.last.next = node;      // 将链表中最后一个节点中的下一节点设为新增节点
            node.prev = this.last;      // 将现链表中最后一个节点设为新增节点中的上一个节点
        }
        this.last = node;   // 将新增节点设为链表中最后一个节点
        this.size++;        // 增加链表节点数量
    }

    /**
     * 查找数据属于链表中的哪个节点
     *
     * @param ele 查找的数据
     * @return 节点
     */
    public Node search(Object ele) {
        Node current = this.first;
        while (current != null) {
            if (current.ele.equals(ele)) {
                return current;
            }
            current = current.next;
        }
        throw new NullPointerException("未找到该数据");
    }

    /**
     * 修改节点中的数据
     *
     * @param oldEle 旧数据
     * @param newEle 新数据
     */
    public void update(Object oldEle, Object newEle) {
        Node current = search(oldEle);
        current.ele = newEle;
    }

    /**
     * 从链表中删除数据
     *
     * @param ele 需要删除的数据
     */
    public void remove(Object ele) {
        // 首先找到需要删除的节点
        Node current = search(ele);

        if (size == 1) {                // 若链表中只有一个节点
            // 将链表的第一个及最后一个节点都设为空
            this.first = null;
            this.last = null;
        } else if (current == first) {      // 若删除的是第一个节点
            this.first.next.prev = null;        // 将现链表中第一个节点的下一个节点中的上一节点设为 null
            this.first = current.next;          // 将删除节点的下一个节点设为第一个节点
        } else if (current == last) {       // 所删除的是最后一个节点
            this.last.prev.next = null;         // 将现链表中的最后一个节点的上一个节点中的下一节点设为 null
            this.last = current.prev;           // 将删除节点的上一个节点设为最后一个节点
        } else {
            current.prev.next = current.next;   // 将删除节点的下一个节点设为新增节点的上一个节点中的下一节点
            current.next.prev = current.prev;   // 将删除节点的上一个节点设为新增节点的下一个节点中的上一节点
        }
        this.size--;    // 减少链表节点数量

    }

}
