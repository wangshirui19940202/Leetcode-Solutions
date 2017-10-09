    // 695. Max Area of Island

    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) return 0;
        int res = 0;
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 1 && !visit[i][j])
                    res = Math.max(res, dfs(grid, visit, i, j));
        return res;
    }
    private int dfs(int[][] grid, boolean[][] visit, int x, int y) {
        if (x < 0 || y < 0|| x == visit.length || y == visit[0].length || visit[x][y] || grid[x][y] == 0) return 0;
        visit[x][y] = true;
        int u = dfs(grid, visit, x - 1, y),
            d = dfs(grid, visit, x + 1, y),
            l = dfs(grid, visit, x, y - 1),
            r = dfs(grid, visit, x, y + 1);
        return 1 + l + r + u + d;
    }
    