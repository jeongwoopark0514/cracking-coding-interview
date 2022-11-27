import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

public class DeleteMiddle {

    public static LinkedListNode deleteNode(LinkedListNode middle) {
        if(middle == null) return null;
        System.out.println(middle.data);
        System.out.println(middle.prev.data);
        middle.prev.next = middle.next;
        middle.prev.next.prev = middle.prev;
        return middle.prev;
    }

    public static void main(String[] args) {
        LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
        System.out.println(head.printForward());
        deleteNode(head.next.next.next.next); // delete node 4
        System.out.println(head.printForward());
    }
}
