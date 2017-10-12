    // 106. Construct Binary Tree from Inorder and Postorder Traversal

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length || inorder.length == 0) return null;
        return dfs(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
    }
    
    private TreeNode dfs(int[] inorder, int[] postorder, int ipost, int sin, int ein) {
        if (ipost < 0 || sin > ein) return null;
        TreeNode root = new TreeNode(postorder[ipost]);
        int i = sin;
        for (; i <= ein; i++)
            if (inorder[i] == postorder[ipost]) break;
        root.right = dfs(inorder, postorder, ipost - 1, i + 1, ein);
        root.left = dfs(inorder, postorder, ipost - (ein - i) - 1, sin, i - 1);
        return root;
    }
    