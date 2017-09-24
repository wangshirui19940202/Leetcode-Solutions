    // 124. Binary Tree Maximum Path Sum

    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        postOrder(root);
        return res;
    }
    private int postOrder(TreeNode root) {
        if(root == null) return 0;
        int l = postOrder(root.left);
        int r = postOrder(root.right);
        int sum = root.val + (l > 0 ? l : 0) + (r > 0 ? r : 0);
        res = Math.max(res, sum);
        return root.val + Math.max(l > 0? l : 0, r > 0? r : 0);
    }