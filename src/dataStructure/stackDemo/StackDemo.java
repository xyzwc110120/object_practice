package dataStructure.stackDemo;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class StackDemo {

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push("A");
        stack.push("B");
        stack.push("B");
        stack.push("C");        // [A, B, B, C]：输出后，栈顶再最后
        System.out.println(stack);
        // 返回对象在堆栈中的位置，以 1 为基数。此方法返回距堆栈顶部最近的出现位置到堆栈顶部的距离；堆栈中最顶部项的距离为 1。
        System.out.println(stack.search("B"));      // 因为距离栈顶最近的B距离栈顶1个位置，所以查询到B的位置为2（1 + 1）。


        Deque deque = new ArrayDeque();
        deque.push("A");
        deque.push("B");
        deque.push("C");        // 将元素插入此双端队列的开头，后插入的在头部（头部部为栈顶）
        System.out.println(deque);      // [C, B, A]：输出后，栈顶在第一，与 Stack类 相反
        System.out.println(deque.peek());
        System.out.println(deque.peekFirst());
    }

}
