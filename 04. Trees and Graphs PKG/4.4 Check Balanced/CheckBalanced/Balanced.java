package CheckBalanced;

import CtCILibrary.AssortedMethods;
import CtCILibrary.TreeNode;
import com.sun.source.tree.Tree;

public class Balanced {

    public static int getHeight(TreeNode node) {
        if(node == null) {
            return -1;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    public static boolean isBalancedBrute(TreeNode root) {
        if(root == null) {
            return true;
        }

        int heightDifference = getHeight(root.left) - getHeight(root.right);
        if(Math.abs(heightDifference) <= 1) {
            return isBalancedBrute(root.left) && isBalancedBrute(root.right);
        } else {
            return false;
        }
    }

    public static int getHeightOptim(TreeNode node) {
        if(node == null) {
            return -1;
        }

        int leftHeight = getHeightOptim(node.left);
        if(leftHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        int rightHeight = getHeightOptim(node.right);
        if(rightHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        int heightDifference = leftHeight - rightHeight;

        if(Math.abs(heightDifference) <= 1) {
            return Math.max(leftHeight, rightHeight) + 1;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public static boolean isBalancedOptim(TreeNode root) {
        return getHeightOptim(root) != Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        // Create balanced tree
//        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        TreeNode root = TreeNode.createMinimalBST(array);
//        System.out.println("Root? " + root.data);
//        System.out.println("Is balanced? " + isBalancedBrute(root));
//
//        // Could be balanced, actually, but it's very unlikely...
//        TreeNode unbalanced = new TreeNode(10);
//        for (int i = 0; i < 10; i++) {
//            unbalanced.insertInOrder(AssortedMethods.randomIntInRange(0, 100));
//        }
//        System.out.println("Root? " + unbalanced.data);
//        System.out.println("Is balanced? " + isBalancedBrute(unbalanced));


        // Create balanced tree
        int[] array = {0, 1, 2, 3, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);


        System.out.println("Is balanced? " + isBalancedOptim(root));

        root.insertInOrder(4); // Add 4 to make it unbalanced

        System.out.println("Is balanced? " + isBalancedOptim(root));
    }
}

