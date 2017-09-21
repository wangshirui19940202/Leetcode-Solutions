    // 654. Maximum Binary Tree

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0) return null;
        return dfs(nums, 0, nums.length - 1);
    }
    private TreeNode dfs(int[] nums, int l, int r) {
        if(l > r) return null;
        int index = l, max = nums[l];
        for(int i = l; i <= r; i++) {
            if(nums[i] > max){
                index = i;
                max = nums[index];
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = dfs(nums, l , index -1);
        root.right = dfs(nums, index + 1, r);
        return root;
    }