import CtCILibrary.AssortedMethods;

import java.util.Stack;

public class sortStack {

    public static Stack<Integer> mergeSort(Stack<Integer> inStack) {
        if (inStack.size() <= 1) {
            return inStack;
        }

        Stack<Integer> left = new Stack<Integer>();
        Stack<Integer> right = new Stack<Integer>();
        int count = 0;

        while(inStack.size() != 0) {
            count ++;

            if(count % 2 == 0) {
                left.push(inStack.pop());
            } else {
                right.push(inStack.pop());
            }
        }
//        System.out.println("Before: " + left + " " + right);
        left = mergeSort(left);
        right = mergeSort(right);
        System.out.println("After: " + left + " " + right);
        while(left.size() > 0 || right.size() > 0) {
            if(left.size() == 0) {
                System.out.println("First condition " + right.peek());
                inStack.push(right.pop());
            } else if (right.size() == 0) {
                System.out.println("Second condition " + left.peek());
                inStack.push(left.pop());
            } else if (right.peek().compareTo(left.peek()) <= 0) {
                System.out.println("Third condition " + left.peek());
                inStack.push(left.pop());
            } else {
                System.out.println("Last condition " + right.peek());
                inStack.push(right.pop());
            }
            System.out.println("InStack: " + inStack);
        }

        Stack<Integer> reverseStack = new Stack<Integer>();
        while(inStack.size() > 0) {
            reverseStack.push(inStack.pop());
        }

        return reverseStack;
    }

    public static void sort(Stack<Integer> s) {
        Stack<Integer> add = new Stack<>();

        while(!s.isEmpty()) {
            int temp = s.pop();

            while(!add.isEmpty() && add.peek() > temp) {
                s.push(add.pop());
            }
            add.push(temp);
        }

        while(!add.isEmpty()) {
            s.push(add.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < 10; i++) {
            int r = AssortedMethods.randomIntInRange(0,  1000);
            s.push(r);
        }

        s = mergeSort(s);

        while(!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
