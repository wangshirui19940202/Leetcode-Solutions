    // 329. Longest Increasing Path in a Matrix
    
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        int res = 0;
        int[][] hash = new int[matrix.length][matrix[0].length];
        for (int x = 0; x < matrix.length; x++) 
            for (int y = 0; y < matrix[0].length; y++)
                res = Math.max(res, dfs(matrix, x, y, Integer.MIN_VALUE, hash));
        return res;
    }
    private int dfs(int[][]matrix, int x, int y, int pre, int hash[][]) {
        if (x == -1 || y == -1 || x == matrix.length || y == matrix[0].length || matrix[x][y] <= pre) return 0;
        if(hash[x][y] != 0) return hash[x][y];
        int u = dfs(matrix, x + 1, y, matrix[x][y], hash),
            d = dfs(matrix, x - 1, y, matrix[x][y], hash),
            l = dfs(matrix, x, y + 1, matrix[x][y], hash),
            r = dfs(matrix, x, y - 1, matrix[x][y], hash);
        hash[x][y] = Math.max(Math.max(u, d), Math.max(l, r)) + 1;
        return hash[x][y];
    }