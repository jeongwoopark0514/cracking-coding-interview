import CtCILibrary.LinkedListNode;

import java.util.Stack;

public class Palindrome_Stack {

    public static Stack<Integer> fillStack(LinkedListNode node) {
        Stack<Integer> sk = new Stack<>();
        while(node != null) {
            sk.push(node.data);
            node = node.next;
        }

        return sk;
    }

    public static boolean checkPalindrome(LinkedListNode node) {
        Stack<Integer> sk = fillStack(node);

        while(node != null) {
            if(node.data != sk.pop()) {
                return false;
            }

            node = node.next;
        }
        return sk.isEmpty();
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
        //nodes[length - 2].data = 9; // Uncomment to ruin palindrome

        LinkedListNode head = nodes[0];
        System.out.println(head.printForward());
        System.out.println(checkPalindrome(head));
    }

}
