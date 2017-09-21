    // 671. Second Minimum Node In a Binary Tree

    public int findSecondMinimumValue(TreeNode root) {
        int res = root.val, next = Integer.MAX_VALUE;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if(cur.val == root.val){ // only add to queue when root.val == cur.val
                    if(cur.left != null) queue.add(cur.left);
                    if(cur.right != null) queue.add(cur.right);
                }else 
                    next = Math.min(next, cur.val);
            }
        }
        return next == Integer.MAX_VALUE ? -1 : next;
    }