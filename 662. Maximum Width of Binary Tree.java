    // 662. Maximum Width of Binary Tree
    // each node's index (starting with root=1), its childnode's index would be index*2 and index*2+1

    public int widthOfBinaryTree(TreeNode root) {
        int[] res = new int[]{1};
        ArrayList<Integer> list = new ArrayList();
        dfs(res, root, list, 0, 1);
        return res[0];
    }
    private void dfs(int[] res, TreeNode root, ArrayList<Integer> list, int h, int index) {
        if(root == null) return;
        if(h == list.size()) {
            list.add(index);
        } else{
            res[0] = Math.max(res[0], index - list.get(h) + 1);
        }
        int nextIdx = index * 2;
        dfs(res, root.left, list, h + 1, nextIdx);
        dfs(res, root.right, list, h + 1, nextIdx + 1);
    }