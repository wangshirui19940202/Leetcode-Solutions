    // 652. Find Duplicate Subtrees

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        LinkedList<TreeNode> res = new LinkedList<>();
        if(root == null) return res;
        HashMap<String, Integer> map = new HashMap();
        postOrder(root, map, res);
        return res;
    }
    private String postOrder(TreeNode root, HashMap<String, Integer> map, LinkedList<TreeNode> res) {
        if(root == null)
            return ".null.";
        String l = postOrder(root.left, map, res), r = postOrder(root.right, map, res);
        String string = "." + root.val + "." + l + r;
        int cur = map.getOrDefault(string, 0);
        if(cur == 1) {
            res.add(root);
            map.put(string, 2);
        } else if(cur == 0){
            map.put(string, 1);
        }
        return string;
    }
    /*
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String, List<TreeNode>> map = new HashMap<>();
        postorder(root, map);
        List<TreeNode> res = new LinkedList<>();
        for(List<TreeNode> list : map.values()) {
            if(list.size() > 1)
                res.add(list.get(0));
        }
        return res;
    }
    private String postorder(TreeNode root, HashMap<String, List<TreeNode>> map) {
        if(null == root) return ",null,";
        String l = postorder(root.left, map);
        String r = postorder(root.right, map);
        String cur = ""+ root.val + l + r; // a preorder string
        if(map.containsKey(cur))
            map.get(cur).add(root);
        else {
            List<TreeNode> list = new LinkedList<>();
            list.add(root);
            map.put(cur, list);
        }
        return cur;
    }
    */