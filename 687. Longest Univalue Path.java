    // 687. Longest Univalue Path

    int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return res;
    }
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int l = dfs(root.left),
            r = dfs(root.right);
        if (l != 0 && root.val != root.left.val)
            l = 0;
        if (r != 0 && root.val != root.right.val)
            r = 0;
        res = Math.max(l + r, res);
        return Math.max(l, r) + 1;
    }