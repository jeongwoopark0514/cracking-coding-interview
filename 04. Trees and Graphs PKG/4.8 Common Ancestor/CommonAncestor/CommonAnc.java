package CommonAncestor;

import CtCILibrary.TreeNode;

class Result {
    TreeNode node;
    boolean isAncestor;

    public Result(TreeNode node, boolean isAncestor) {
        this.node = node;
        this.isAncestor = isAncestor;
    }
}
public class CommonAnc {
    public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Result res = commonAncestorHelper(root, p, q);
        if(res.isAncestor) return res.node;
        return null;
    }

    public static Result commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return new Result(null, false);
        if(root == p && root == q) return new Result(root, true);

        Result rx = commonAncestorHelper(root.left, p, q);
        if(rx.isAncestor) return rx;
        Result ry = commonAncestorHelper(root.right, p, q);
        if(ry.isAncestor) return ry;

        if(rx.node != null && ry.node != null) {
            return new Result(root, true);
        } else if (root == p || root == q) {
            boolean isAnc = rx.node != null || ry.node != null;
            return new Result(root, isAnc);
        } else {
            return new Result(rx.node == null? ry.node : rx.node, false);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);

        TreeNode n3 = root.find(6);
        TreeNode n7 = root.find(11);
        TreeNode ancestor = commonAncestor(root, n3, n7);

        if (ancestor != null) {
            System.out.println(ancestor.data);
        } else {
            System.out.println("null");
        }
    }
}
