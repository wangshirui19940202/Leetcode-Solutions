    // 113. Path Sum II

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        dfs(root, sum, new LinkedList<Integer>(), res);
        return res;
    }
    private void dfs(TreeNode root, int sum, LinkedList<Integer> list, List<List<Integer>> res) {
        if(root == null) return;
        list.add(root.val);
        if(root.left == null && root.right == null) {
            if(root.val == sum) {
                res.add(new LinkedList(list));
            }
        } else {
            dfs(root.left, sum - root.val, list, res);
            dfs(root.right, sum - root.val, list, res);
        }
        list.removeLast();
    }
    