package ValidateBST;

import CtCILibrary.TreeNode;

public class ValidateBST {
    public static Integer lastPrinted = null;

    public static boolean checkBST(TreeNode node) {
        // Binary Search Tree should satisfy a condition that lef.data <= current.data < right.data
        return checkBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean checkBST(TreeNode node, int min, int max) {
        if(node == null) return true;

        // Right Tree, Left Tree
        if(node.data <= min || node.data > max) {
            return false;
        }

        boolean leftCheck = checkBST(node.left, min, node.data);
        boolean rightCheck = checkBST(node.right, node.data, max);
        return leftCheck && rightCheck;
    }



    public static void main(String[] args) {
        int[] array = {Integer.MIN_VALUE, Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 1, Integer.MAX_VALUE};
        TreeNode node = TreeNode.createMinimalBST(array);
        //node.left.data = 5;
        //node.left.right.data = 3;
        System.out.println(checkBST(node));

        test();
    }

    public static void test() {
        TreeNode node;
        boolean condition;
        System.out.println("test cases for equals condition.");

		/* Expect true: for left child: node.data <= last_printed.
   2
  / \
 /   \
 2   3
      \
      4
		*/
        int[] array2 = {1, 2, 3, 4};
        node = TreeNode.createMinimalBST(array2);
        node.left.data = 2;
        node.print();
        lastPrinted = null;
        condition = checkBST(node);
        System.out.println("should be true: " + condition);

		/* Expect false: for right child: node.data <= last_printed.
   2
  / \
 /   \
 1   2
      \
      4
		 */
        int[] array3 = {1, 2, 3, 4};
        node = TreeNode.createMinimalBST(array3);
        node.right.data = 2;
        node.print();
        lastPrinted = null;
        condition = checkBST(node);
        System.out.println("should be false: " + condition);
    }
}
