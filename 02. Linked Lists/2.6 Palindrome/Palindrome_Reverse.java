import CtCILibrary.LinkedListNode;

public class Palindrome_Reverse {
//    #5, #13, #29, #61, #101
    // #5 what if you reverse the linkedlist
    // #13 Try using a stack
    // #29 Assume you have the length of the linkedlist. Can you implement this recursively?
    // #61

    public static LinkedListNode reverseLL(LinkedListNode node) {
        LinkedListNode reversed = null;
        while(node != null) {
//            clone
            LinkedListNode n = new LinkedListNode(node.data);
            n.next = reversed;
            reversed = n;
            node = node.next;
        }
        return reversed;
    }

    public static boolean palindrome(LinkedListNode node) {
        LinkedListNode reversed = reverseLL(node);

        while(reversed != null && node != null) {
            if(reversed.data != node.data) {
                return false;
            }
            reversed = reversed.next;
            node = node.next;
        }

        // Make sure the reversed list and the node has the same length by checking if they reached the end.
        return reversed == null && node == null;
    }

    public static void main(String[] args) {
        int length = 9;
        LinkedListNode[] nodes = new LinkedListNode[length];
        for (int i = 0; i < length; i++) {
            nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i, null, null);
        }

        for (int i = 0; i < length; i++) {
            if (i < length - 1) {
                nodes[i].setNext(nodes[i + 1]);
            }
            if (i > 0) {
                nodes[i].setPrevious(nodes[i - 1]);
            }
        }
        // nodes[length - 2].data = 9; // Uncomment to ruin palindrome

        LinkedListNode head = nodes[0];
        System.out.println(head.printForward());
        System.out.println(palindrome(head));
    }
}
