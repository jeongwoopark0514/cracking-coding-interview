import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

class IntersectionResult {
    public LinkedListNode tail;
    public int size;
    public IntersectionResult(LinkedListNode tail, int size) {
        this.tail = tail;
        this.size = size;
    }
}
public class Intersection {

    public static LinkedListNode findIntersection(LinkedListNode list1, LinkedListNode list2) {
        if (list1 == null || list2 == null) {
            return null;
        }

        // Check for the tail node
        IntersectionResult checkTail1 = getTailSize(list1);
        IntersectionResult checkTail2 = getTailSize(list2);

        if(checkTail2.tail != checkTail1.tail) return null;

        LinkedListNode longer = checkTail1.size > checkTail2.size ? list1 : list2;
        LinkedListNode shorter = checkTail1.size > checkTail2.size ? list2 : list1;

        longer = advancePointer(longer, Math.abs(checkTail1.size - checkTail2.size));

        while(shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }

        return longer;
    }

    public static LinkedListNode advancePointer(LinkedListNode node, int k) {
        LinkedListNode current = node;
        while(k > 0 && node != null) {
            current = current.next;
            k--;
        }
        return current;
    }

    public static IntersectionResult getTailSize(LinkedListNode node) {
        LinkedListNode checkTail = node;
        int size = 0;
        while(checkTail != null) {
            size++;
            checkTail = checkTail.next;
        }
        return new IntersectionResult(checkTail, size);
    }

    public static void main(String[] args) {
        /* Create linked list */
        int[] vals = {-1, -2, 0, 1, 2, 3, 4, 5, 6, 7, 8};
        LinkedListNode list1 = AssortedMethods.createLinkedListFromArray(vals);

        int[] vals2 = {12, 14, 15};
        LinkedListNode list2 = AssortedMethods.createLinkedListFromArray(vals2);

        list2.next.next = list1.next.next.next.next;

        System.out.println(list1.printForward());
        System.out.println(list2.printForward());


        LinkedListNode intersection = findIntersection(list1, list2);

        System.out.println(intersection.printForward());
    }
}


