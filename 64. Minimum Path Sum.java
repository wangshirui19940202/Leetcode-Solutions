    // 64. Minimum Path Sum
    
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) return 0;
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) dp[i][0] = grid[i][0] + dp[i - 1][0];
        for (int i = 1; i < grid[0].length; i++) dp[0][i] = grid[0][i] + dp[0][i - 1];
        for (int i = 1; i < grid.length; i++)
            for (int j = 1; j < grid[0].length; j++)
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
        return dp[grid.length - 1][grid[0].length - 1];
    }
          
    
    /*
    public int minPathSum(int[][] grid) {
        int[][] hush = new int[grid.length][grid[0].length];
        for(int i=0;i<hush.length;i++)
            for(int j=0;j<hush[0].length;j++)
                hush[i][j]=-1;
        return findMinpath(grid,0,0,hush);
    }

    int findMinpath(int[][] grid, int row, int colum, int[][] hush) {
        if (row >= grid.length || colum >= grid[0].length) return Integer.MAX_VALUE;
        if (hush[row][colum] != -1) return hush[row][colum];
        if (row == grid.length - 1 && colum == grid[0].length - 1) {
            return grid[row][colum];
        }
        hush[row][colum] = grid[row][colum] + Math.min(findMinpath(grid, row + 1, colum, hush), findMinpath(grid, row, 1 + colum, hush));
        return hush[row][colum];
    }
    */