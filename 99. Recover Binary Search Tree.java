    // 99. Recover Binary Search Tree

    TreeNode first = null;
    TreeNode second = null;
    TreeNode pre = new TreeNode(Integer.MIN_VALUE);
    
    public void recoverTree(TreeNode root) {
        inorder(root);
        int t = first.val;
        first.val = second.val;
        second.val = t;
        return;
    }
    
    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder (root.left);
        if (first == null && pre.val > root.val)
            first = pre;
        if (first != null && pre.val > root.val)
            second = root;
        pre = root;
        inorder (root.right);
    }