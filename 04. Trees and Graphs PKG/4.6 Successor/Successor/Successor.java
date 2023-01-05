package Successor;

import CtCILibrary.TreeNode;
import com.sun.source.tree.Tree;

public class Successor {

    public static TreeNode inorderSucc(TreeNode node) {
        if(node == null) return null;

        if(node.parent == null || node.right != null) {
            TreeNode temp = node.right;

            while(temp.left != null) {
                temp = temp.left;
            }

            return temp;
        } else {
            TreeNode temp = node;
            TreeNode q = temp.parent;

            while(q != null && q.left != temp) {
                temp = q;
                q = temp.parent;
            }
            return q;

        }

    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);
        for (int i = 0; i < array.length; i++) {
            TreeNode node = root.find(array[i]);
            TreeNode next = inorderSucc(node);
            if (next != null) {
                System.out.println(node.data + "->" + next.data);
            } else {
                System.out.println(node.data + "->" + null);
            }
        }
    }
}
