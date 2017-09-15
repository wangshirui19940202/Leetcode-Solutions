
    // 463. Island Perimeter

    public int islandPerimeter(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int res = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    res +=4;
                    if(i + 1 < grid.length && grid[i + 1][j] == 1) res -= 2;
                    if(j + 1 < grid[0].length && grid[i][j + 1] == 1) res -= 2;
                }
            }
        }
        return res;
    }
    
    /*
    int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
    int res=0;
    public int islandPerimeter(int[][] grid) {
        if(grid.length==0||grid[0].length==0) return 0;
        int[][]visit=new int[grid.length][grid[0].length];
        for(int x=0;x<visit.length;x++)
            for(int y=0;y<visit[0].length;y++)
                helper(x,y,visit,grid);
        return res;
    }
    private void helper(int x, int y, int[][]visit, int[][]grid){
        if(y<0||y>=visit[0].length||x<0||x>=visit.length||grid[x][y]==0||visit[x][y]==1){return;}
        visit[x][y]=1;
        for(int [] i:dir){
            if(y+i[1]<0||y+i[1]>=visit[0].length||x+i[0]<0||x+i[0]>=visit.length||grid[x+i[0]][y+i[1]]==0)
                res++;
        }
        for(int [] i:dir){
            helper(x+i[0],y+i[1],visit,grid);
        }
    }
    */