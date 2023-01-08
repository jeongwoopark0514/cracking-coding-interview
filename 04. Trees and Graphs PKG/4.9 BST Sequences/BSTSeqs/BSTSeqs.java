package BSTSeqs;

import CtCILibrary.TreeNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class BSTSeqs {

    public static void printArrayListLinkedList(ArrayList<LinkedList<Integer>> results, String name) {
        System.out.println("Results. size: " + results.size());

        for(LinkedList<Integer> ele : results) {
            System.out.println(name + " : " + Arrays.toString(ele.toArray()));
        }
    }

    public static ArrayList<LinkedList<Integer>> allSequences(TreeNode node) {
        ArrayList<LinkedList<Integer>> results = new ArrayList<LinkedList<Integer>>();
        if(node == null) {
            results.add(new LinkedList<Integer>());
            return results;
        }

        LinkedList<Integer> prefix = new LinkedList<Integer>();
        prefix.add(node.data);

        ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
        ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);

        for(LinkedList<Integer> left : leftSeq) {
            for(LinkedList<Integer> right : rightSeq) {
                results.addAll(weaveLists(left, right, prefix));
            }
        }

        return results;
    }

    public static ArrayList<LinkedList<Integer>> weaveLists(LinkedList<Integer> first, LinkedList<Integer> second, LinkedList<Integer> prefix) {

        ArrayList<LinkedList<Integer>> results = new ArrayList<LinkedList<Integer>>();
        if(first.isEmpty() || second.isEmpty()) {
            LinkedList<Integer> cloned = (LinkedList<Integer>) prefix.clone();
            cloned.addAll(first);
            cloned.addAll(second);
            results.add(cloned);
            return results;
        }

        int headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        results.addAll(weaveLists(first, second, prefix));
        first.addFirst(prefix.removeLast());

        int headSecond = second.removeFirst();
        prefix.addLast(headSecond);
        results.addAll(weaveLists(first, second, prefix));
        second.addFirst(prefix.removeLast());
        return results;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(100);
        int[] array = {100, 50, 20, 75, 150, 120, 170};
        for (int a : array) {
            node.insertInOrder(a);
        }
        ArrayList<LinkedList<Integer>> allSeq = allSequences(node);
        for (LinkedList<Integer> list : allSeq) {
//            System.out.println(list);
        }
        System.out.println(allSeq.size());
    }
}
