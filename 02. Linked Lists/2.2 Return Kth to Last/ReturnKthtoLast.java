import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

public class ReturnKthtoLast {
//    Hints:#8, #25, #41, #67, #126
// What if you knew the linked list size? What is the difference between finding the Kth-tolast element and finding the Xth element?
//If you don't know the linked list size, can you compute it? How does this impact the
//    runtime?
//Try implementing it recursively. If you could find the (K-l)th to last element, can you
//    find the Kth element?
//You might find it useful to return multiple values. Some languages don't directly support
//            this, but there are workarounds in essentially any language. What are some of those
//    workarounds?
//Can you do it iteratively? Imagine if you had two pointers pointing to adjacent nodes
//    and they were moving at the same speed through the linked list. When one hits the end
//    of the linked list, where will the other be?
    public static int printKthLast(LinkedListNode singleList, int k) {
        if(singleList == null) {
            return 0;
        }
        int count = printKthLast(singleList.next, k) + 1;
        if(count == k) {
            System.out.println(singleList.data);
        }
        return count;
    }

    // Place the pointer k nodes apart in the linked list by putting pointer2 at the beginning
    // and moving pointer1 k nodes into the list. Then, move them at the same pace.
    public static int printKthLastIterative(LinkedListNode singleList, int k) {
        LinkedListNode pointer = singleList;
        LinkedListNode answer = singleList;

        for(int i = 0; i < k; i++) {
            if(pointer == null) return answer.data;
            pointer = pointer.next;
        }

        int lastVal = answer.data;
        while(pointer != null) {
//            System.out.println(pointer.data + "; " + answer.data);
            lastVal = answer.data;
            pointer = pointer.next;
            answer = answer.next;
        }
        return lastVal;
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6};
        LinkedListNode head = AssortedMethods.createLinkedListFromArray(array);
//        printKthLast(head, 7);
//        for (int i = 0; i <= array.length + 1; i++) {
//            printKthLast(head, i);
//        }

        for (int i = 0; i <= array.length; i++) {
            System.out.println(printKthLastIterative(head, i));
        }
    }
}

