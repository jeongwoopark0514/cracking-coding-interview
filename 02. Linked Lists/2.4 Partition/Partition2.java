import CtCILibrary.LinkedListNode;

public class Partition2 {

    public static LinkedListNode partition2(LinkedListNode node, int x) {
        LinkedListNode head = node;
        LinkedListNode tail = node;
        System.out.println("tail value: " + tail);

        while(node != null) {
            LinkedListNode next = node.next;

            if(node.data < x) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                System.out.println("node.value: " + node.data);
                tail = node;
            }

            node = next;
        }

        tail.next = null;

        return head;
    }

    public static void main(String[] args) {
        /* Create linked list */
        int[] vals = {33,9,2,3,10,10389,838,874578,5};
        LinkedListNode head = new LinkedListNode(vals[0], null, null);
        LinkedListNode current = head;
        for (int i = 1; i < vals.length; i++) {
            current = new LinkedListNode(vals[i], null, current);
        }
        System.out.println(head.printForward());

        /* Partition */
        LinkedListNode h = partition2(head, 3);

        /* Print Result */
        System.out.println(h.printForward());
    }
}