import java.util.Stack;

public class MyQueue<T> {

    Stack<T> stackNew;
    Stack<T> stackOld;

    public MyQueue() {
        stackNew = new Stack<>();
        stackOld = new Stack<>();
    }

    public int size() {
        return stackNew.size() + stackOld.size();
    }

    public void add(T value) {
        stackNew.push(value);
    }

    // if stackold is not empty, just wait until it becomes empty
    public void reverseStack() {
        if (stackOld.isEmpty()) {
            while(!stackNew.isEmpty()) {
                stackOld.push(stackNew.pop());
            }
        }
    }

    public T peek() {
        reverseStack();
        return stackOld.peek();
    }

    public T remove() {
        reverseStack();
        return stackOld.pop();
    }
}
