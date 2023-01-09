package RandomNode;

import java.util.Random;

public class Tree {
    TreeNode root = null;

    public int size() {
        return root == null ? 0: root.size();
    }

    public TreeNode getRandomNode() {
        if(root == null) {
            return null;
        }

        Random rand = new Random();
        int index = rand.nextInt(size());

        return root.getIthNode(index);
    }

    public void insertInOrder(int x) {
        if(root == null) {
            root = new TreeNode(x);
        } else {
            root.insertInOrder(x);
        }
    }
}
