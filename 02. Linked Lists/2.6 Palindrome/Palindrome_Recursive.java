import CtCILibrary.LinkedListNode;

class Result {
    LinkedListNode node;
    boolean result;

    public Result(LinkedListNode node, boolean result) {
        this.node = node;
        this.result = result;
    }
}

public class Palindrome_Recursive {

    public static boolean isPalindrome(LinkedListNode node) {
        int length = lengthOfLinkedList(node);

        return isPalindrome(node, length).result;
    }

//    1, 2, 3, 3, 2, 1
    public static Result isPalindrome(LinkedListNode node, int length) {
        if(length <= 0 || node == null) {
            System.out.println(node.data + "; " + node.next.data);
            return new Result(node, true);
        } else if (length == 1) {
            return new Result(node.next, true);
        }

        // put nodes upto the middle of linkedlist into the stack.
        // 중간 값이 res에 저장되고...
        Result res = isPalindrome(node.next, length-2);
        if(!res.result || res.node == null) {
            return res;
        }
//        if(res.node.data != node.data) {
//            System.out.println("returned.node.data: " + res.node.data);
//            System.out.println("node.data: " + node.data);
//            res.result = false;
//        }
        // node.data는 스택을 읽어옴
        res.result = (node.data == res.node.data);
        res.node = res.node.next;

        return res;
    }

    public static int lengthOfLinkedList(LinkedListNode node) {
        int length = 0;

        while(node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    public static void main(String[] args) {
        int length = 10;
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
        System.out.println(isPalindrome(head));
    }
}

