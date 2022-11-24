import CtCILibrary.LinkedListNode;

import java.util.HashSet;

public class RemoveDups {
//  Hints: #9, #40
//Have you tried a hash table? You should be able to do this in a single pass of the linked
//            list

//    Without extra space, you'll need O(N2
//            ) time. Try using two pointers, where the second
//    one searches ahead of the first one


    public static LinkedListNode removeDuplicates(LinkedListNode unsorted) {
        HashSet<Integer> set = new HashSet<>();

        while(unsorted != null) {
            if(set.contains(unsorted.data)) {
                LinkedListNode temp = unsorted.next;
                unsorted.prev.setNext(temp);
                if(temp != null)
                    temp.setPrevious(unsorted.prev);
            } else {
                set.add(unsorted.data);
            }
            unsorted = unsorted.next;
        }
        return unsorted;
    }

    public static LinkedListNode delDups(LinkedListNode unsorted) {

        while(unsorted != null) {
            LinkedListNode pointer = unsorted;

            while(pointer != null) {
                if(pointer.next != null && pointer.next.data == unsorted.data) {
                    LinkedListNode doubleNext = pointer.next.next;
                    pointer.setNext(doubleNext);
                    if(doubleNext != null ) doubleNext.setPrevious(pointer);
                } else {
                    pointer = pointer.next;
                }
            }
            unsorted = unsorted.next;
        }
        return unsorted;
    }

    public static void main(String[] args) {
        LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
        LinkedListNode head = first;
        LinkedListNode second = first;
        for (int i = 1; i < 8; i++) {
            second = new LinkedListNode(i % 2, null, null);
            first.setNext(second);
            second.setPrevious(first);
            first = second;
        }
        System.out.println(head.printForward());
        delDups(head);
        System.out.println(head.printForward());
    }
}
