import CtCILibrary.AssortedMethods;

import java.util.EmptyStackException;

class FixedMultiStack {
    private int stackSize;
    private int[] values;
    private int[] sizesOfStacks;

    public FixedMultiStack(int stacksize) {
        this.stackSize = stacksize;
        this.values = new int[this.stackSize * 3];
        sizesOfStacks = new int[this.stackSize];
    }

    public void push(int sN, int value) throws Exception {
        if(this.sizesOfStacks[sN] == this.stackSize) {
            throw new Exception("Stack is Full.");
        }
        this.sizesOfStacks[sN] ++;
        this.values[indexOfTop(sN)] = value;
    }

    public int pop(int sN) {
        if(isEmpty(sN)) throw new EmptyStackException();
        int topIndex = indexOfTop(sN);
        int value = this.values[topIndex];
        values[topIndex] = 0;
        this.sizesOfStacks[sN]--;
        return value;
    }

    public int peek(int sN) {
        if(isEmpty(sN)) throw new EmptyStackException();
        int topIndex = indexOfTop(sN);
        int value = this.values[topIndex];
        return value;
    }

    public boolean isEmpty(int sN) {
        return this.sizesOfStacks[sN] == 0;
    }

    private int indexOfTop(int sN) {
        int offset = sN * this.stackSize;
        int size = this.sizesOfStacks[sN];
        return offset + size - 1;
    }

    public int[] getValues() {
        return values;
    }
}

public class ThreeInOneFixed {
//     #2, #12, #38, #58
//    If you want to allow for flexible divisions, you can shift stacks around. Can you ensure
//that all available capacity is used?
//    Try thinking about the array as circular, such that the end of the array "wraps around"to
//the start of the array.
    public static void printStacks(FixedMultiStack stacks) {
        System.out.println(AssortedMethods.arrayToString(stacks.getValues()));
    }
    public static void main(String[] args) throws Exception {
        FixedMultiStack stacks = new FixedMultiStack(4);
        printStacks(stacks);
        stacks.push(0, 10);
        printStacks(stacks);
        stacks.push(1, 20);
        printStacks(stacks);
        stacks.push(2, 30);
        printStacks(stacks);

        stacks.push(1, 21);
        printStacks(stacks);
        stacks.push(0, 11);
        printStacks(stacks);
        stacks.push(0, 12);
        printStacks(stacks);

        stacks.pop(0);
        printStacks(stacks);

        stacks.push(2, 31);
        printStacks(stacks);

        stacks.push(0, 13);
        printStacks(stacks);
        stacks.push(1, 22);
        printStacks(stacks);

        stacks.push(2, 31);
        printStacks(stacks);
        stacks.push(2, 32);
        printStacks(stacks);
    }
}
