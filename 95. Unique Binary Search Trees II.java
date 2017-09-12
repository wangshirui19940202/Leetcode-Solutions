    // 95. Unique Binary Search Trees II
    // dp
    
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] dp = new List[n + 1];
        dp[0] = new ArrayList<>();
        if(n == 0) return dp[0];
        dp[0].add(null);
        
        for(int i = 1; i <= n; i++) {
            dp[i] = new ArrayList();
            for(int j = 0; j < i; j++) {
                for(TreeNode l : dp[j]) {
                    for(TreeNode r : dp[i - j - 1]) {
                        TreeNode root = new TreeNode(j + 1);
                        root.left = l;//clone(l, 0);
                        root.right = clone(r, j + 1);
                        dp[i].add(root);
                    }
                }
            }
        }
        return dp[n];
    }
    private TreeNode clone(TreeNode ori, int offset) {
        if(ori == null) return null;
        TreeNode res = new TreeNode(ori.val + offset);
        res.left = clone(ori.left, offset);
        res.right = clone(ori.right, offset);
        return res;
    }
    
    
    /*
    public List<TreeNode> generateTrees(int n) {
        if(n<=0) return new LinkedList<TreeNode>();
        return dfs(1, n);
    }
    private LinkedList<TreeNode> dfs(int s, int e){
        LinkedList<TreeNode> res=new LinkedList<>();
        if (s > e){
            res.add(null);
        }
        else if(s==e) res.add(new TreeNode(s));
        else {
            for(int i=s;i<=e;i++){
                LinkedList<TreeNode> l = dfs(s , i-1);
                LinkedList<TreeNode> r = dfs(i+1 , e);
                for(TreeNode lr : l)
                    for(TreeNode rr : r){
                        TreeNode root=new TreeNode(i);
                        root.left=lr;
                        root.right=rr;
                        res.add(root);
                    }
            }
        }
        return res;
    }
    */
    