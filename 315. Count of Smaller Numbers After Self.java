    // 315. Count of Smaller Numbers After Self

    class TreeNode {
        int val;
        int small = 0;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        if (nums.length == 0) return new LinkedList();
        Integer[] res = new Integer[nums.length];
        res[nums.length - 1] = 0;
        TreeNode root = new TreeNode(nums[nums.length - 1]);
        for (int i = nums.length - 2; i >= 0; i--) {
            res[i] = 0;
            dfs(root, new TreeNode(nums[i]), res, i);
        }
        return Arrays.asList(res);
    }
    private void dfs(TreeNode root, TreeNode cur, Integer[] res, int index) {
        if (root.val <= cur.val) {
            res[index] += root.small + (root.val == cur.val ? 0 : 1);
            if (root.right == null) root.right = cur;
            else dfs(root.right, cur, res, index);
        } else {
            root.small++;
            if (root.left == null) root.left = cur;
            else dfs(root.left, cur, res, index);
        }
    }
    
    
    
    
    /*
    // TLE
    class TreeNode {
        int val;
        int res = 0;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        if (nums.length == 0) return new LinkedList();
        int[] res = new int[nums.length];
        TreeNode[] nodes = new TreeNode[nums.length];
        nodes[0] = new TreeNode(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            TreeNode cur = new TreeNode(nums[i]);
            nodes[i] = cur;
            dfs (nodes[0], cur);
        }
        LinkedList<Integer> res = new LinkedList();
        for (TreeNode n : nodes) res.add(n.res);
        return res;
    }
    private void dfs(TreeNode root, TreeNode cur, int[] res, int index) {
        if (cur.val >= root.val) {
            if (root.right == null) root.right = cur;
            else dfs(root.right, cur);
        } else {
            root.res ++;
            update(root.right);
            if (root.left == null) root.left = cur;
            else dfs (root.left, cur);
        }
    }
    private void update(TreeNode root){
        if (root == null) return;
        root.res ++;
        update(root.left);
        update(root.right);
    }
    */