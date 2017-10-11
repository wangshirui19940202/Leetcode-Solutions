    // 572. Subtree of Another Tree
    
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null)
            return t == null;
        return check(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    private boolean check(TreeNode s, TreeNode t) {
        if (s == null || t == null)
            return t == null && s == null;
        return s.val == t.val && check(s.left, t.left) && check(s.right, t.right);
    }
    /*
    public boolean isSubtree(TreeNode s, TreeNode t) {
        StringBuilder l = new StringBuilder(), r = new StringBuilder();
        preorder(l, s);
        preorder(r, t);
        return l.toString().contains(r.toString());
    }
    private void preorder(StringBuilder sb, TreeNode root){
        if(root == null){
            sb.append(",null,");
            return;
        }
        sb.append("," + String.valueOf(root.val) + ",");
        preorder(sb, root.left);
        preorder(sb, root.right);
    }
    */