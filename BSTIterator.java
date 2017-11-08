// BST Iterator

public class BSTIterator {

    class TreeNode {
        int val;
        TreeNode left, right, parent;
    }

    TreeNode root;
    TreeNode cur;

    public BSTIterator( TreeNode root ) {
        this.root = root;
        this.cur = root;
        while (cur != null && cur.left != null) 
            cur = cur.left;
    }

    public boolean hasNext() {
        return cur != null;
    }

    public int next() {
        if (cur == null) throw new RuntimeException("");
        int res = cur.val;
        if (cur.right != null) {
            cur = cur.right;
            while (cur != null && cur.left != null) 
                cur = cur.left;
        } else {
            TreeNode parent = cur.parent;
            while (parent != null && parent.right == cur) {
                cur = cur.parent;
                parent = parent.parent;
            }
            cur = parent;
        }
        return res;
    }

}

