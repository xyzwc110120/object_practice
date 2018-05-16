package dataStructure.linkedListDemo;

public class LinkedListDemo {

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();

        linkedList.addLast("C");
        System.out.println(linkedList);

        linkedList.addFirst("B");
        linkedList.addLast("D");
        linkedList.remove("C");
        linkedList.addFirst("A");
        System.out.println(linkedList);
        linkedList.update("D", "E");
        System.out.println(linkedList);

        System.out.println(linkedList.search("B").ele);
    }

}
