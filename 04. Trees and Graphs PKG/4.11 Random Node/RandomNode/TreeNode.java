package RandomNode;

public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;
    private int size = 0;

    public TreeNode(int d) {
        data = d;
        size = 1;
    }

    public int size() {
        return this.size;
    }

    public TreeNode getIthNode(int index) {
        int leftSize = left == null ? 0: left.size();

        if(index < leftSize) {
            return left.getIthNode(index);
        } else if (index == leftSize) {
            return this;
        } else {
//            index > leftSize
            // Deletes left side of the current tree including the root
            return right.getIthNode(index - (leftSize+ 1));
        }
    }

    public void insertInOrder(int x) {
        if (x < data) {
            if(left == null) {
                left = new TreeNode(x);
            } else {
                left.insertInOrder(x);
            }
        } else {
            if(right == null) {
                right = new TreeNode(x);
            } else {
                right.insertInOrder(x);
            }
        }
        size ++;
    }

    public TreeNode find(int x) {
        if (x == data) {
            return this;
        } else  if (x < data) {
            return left != null ? left.find(x) : null;
        } else {
            return right != null ? right.find(x) : null;
        }
    }
}
