// 一棵树，所有节点的value都是正整数，问只能增加某些节点值的情况下，如何调整使得从root到所有leaf的path上经过的节点值之和相等，返回增加的值的和，使这个和最小 


    public void balanceTree(TreeNode root) {
        dfsBalance(root);
    }
    private int dfsBalance(TreeNode root) {
        if (root == null) return 0;
        int l = dfsBalance(root.left);
        int r = dfsBalance(root.right);
        int pathSum = Math.max(l, r);
        int extra = Math.abs(l - r);
        if (pathSum != l && root.left != null) root.left.val += extra;
        else if (pathSum != r && root.right != null) root.right.val += extra;
        return pathSum + root.val;
    }
    
    
    
    /**********************************/
    public void run(){
        
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(4);
        root.left.right=new TreeNode(4);
        root.left.right.left=new TreeNode(1);
        root.left.left=new TreeNode(2);
        root.right=new TreeNode(7);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(1);
         /*
                    5
                  /    \
                 4      7
                /  \   /  \
               2    4 6    1
                   /
                  1
        */
        bsfPrintTree(root);
        balanceTree(root);
        bsfPrintTree(root);
    }
    private void bsfPrintTree(TreeNode root){
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
                System.out.print(cur.val + "  ");
            }
            System.out.println("");
        }
    }