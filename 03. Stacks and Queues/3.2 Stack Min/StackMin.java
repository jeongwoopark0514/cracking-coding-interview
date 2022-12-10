import org.w3c.dom.Node;

import java.util.Stack;

class StackWithMin extends Stack<NodeWithMin> {
    public void push(int value) {
        int newMin = Math.min(min(), value);
        super.push(new NodeWithMin(value, newMin));
    }

    public int min() {
        if(super.isEmpty()) return Integer.MAX_VALUE;
        return peek().min;
    }
}

class NodeWithMin {
    int value;
    int min;

    public NodeWithMin(int value, int min) {
        this.value = value;
        this.min = min;
    }
}

class StackWithMin2 extends Stack<Integer>{
    Stack<Integer> s2;

    public StackWithMin2() {
        s2 = new Stack<Integer>();
    }

    public void push(int value) {
        if(value <= min()) {
            s2.push(value);
        }
        super.push(value);
    }
    public Integer pop() {
        int value = super.pop();
        if(value == min()) {
            s2.pop();
        }
        return value;
    }

    public int min() {
        if(s2.isEmpty()) return Integer.MAX_VALUE;
        return s2.peek();
    }
}

public class StackMin {
    public static void main(String[] args) {
        StackWithMin stack = new StackWithMin();
        StackWithMin2 stack2 = new StackWithMin2();
        int[] array = {2, 1, 3, 1};
        for (int value : array) {
            stack.push(value);
            stack2.push(value);
            System.out.print(value + ", ");
        }
        System.out.println('\n');
        for (int i = 0; i < array.length; i++) {
            System.out.println("Popped " + stack.pop().value + ", " + stack2.pop());
            System.out.println("New min is " + stack.min() + ", " + stack2.min());
        }
    }
}
