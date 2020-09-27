package dataStructure.DequeDemo;

import dataStructure.linkedListDemo.MyLinkedList;

// 双向队列（模拟）
public class MyDeque extends MyLinkedList {

    public Object getFirst() {
        return super.first;
    }

    public Object getLast() {
        return super.last;
    }

    public void removeFirst() {
        remove(super.first);
    }

    public void removeLast() {
        remove(super.last);
    }

    public void addFirst(Object ele) {
        super.addFirst(ele);
    }

    public void addLast(Object ele) {
        super.addLast(ele);
    }
}
