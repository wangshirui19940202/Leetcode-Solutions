    // 417. Pacific Atlantic Water Flow

    // bfs
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new LinkedList<>();
        if(matrix.length == 0) return res;
        boolean[][] left = new boolean[matrix.length][matrix[0].length], right = new boolean[matrix.length][matrix[0].length];
        
        Queue<int[]> leftQ = new LinkedList(), rightQ = new LinkedList(); 
        for(int i = 0; i < matrix.length; i++) {
            leftQ.add(new int[]{i, 0});
            rightQ.add(new int[]{i, matrix[0].length - 1});
            left[i][0] = true;
            right[i][matrix[0].length - 1] = true;
        }
        for(int i = 1; i < matrix[0].length; i++) {
            leftQ.add(new int[]{0, i});
            left[0][i] = true;
        }
        for(int i = 0; i < matrix[0].length - 1; i++) {
            rightQ.add(new int[]{matrix.length - 1, i});
            right[matrix.length - 1][i] = true;   
        }
        bfs(leftQ, matrix, left);
        bfs(rightQ, matrix, right);
        
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[0].length; j++)
                if(left[i][j] && right[i][j])
                    res.add(new int[]{i, j});
        return res;
    }
    
    private void bfs(Queue<int[]> queue, int[][] matrix, boolean[][] visit) {
        int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for(int[] d : dir) {
                int nx = cur[0] + d[0], ny = cur[1] + d[1];
                if(nx < 0 || ny < 0 || nx == visit.length || ny == visit[0].length || visit[nx][ny] || matrix[nx][ny] < matrix[cur[0]][cur[1]]) continue;
                visit[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }
    }
    
    
    
    /*
    // dfs
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new LinkedList();
        if(matrix.length==0) return res;
        int xmax=matrix.length, ymax=matrix[0].length;
        boolean[][] lvisit=new boolean[xmax][ymax];
        boolean[][] rvisit=new boolean[xmax][ymax];
        for(int i=0;i<ymax;i++){ 
            DFS(0,i,matrix,Integer.MIN_VALUE,lvisit);
            DFS(xmax-1,i,matrix,Integer.MIN_VALUE,rvisit);
        }
        for(int i=0;i<xmax;i++){ 
            DFS(i,0,matrix,Integer.MIN_VALUE,lvisit);
            DFS(i,ymax-1,matrix,Integer.MIN_VALUE,rvisit);
        }
        for(int x=0;x<xmax;x++)
            for(int y=0;y<ymax;y++)
                if(lvisit[x][y]&&rvisit[x][y])
                    res.add(new int[] {x, y});
        return res;
    }
    
    private void DFS(int x, int y, int[][]matrix, int last, boolean visit[][]){
        //System.out.println(x+" "+y+"::"+matrix.length+" "+matrix[0].length);
        if(x<0||y<0||x>=matrix.length||y>=matrix[0].length||visit[x][y]||last>matrix[x][y]) return;
        visit[x][y] = true;
        DFS(x-1,y,matrix,matrix[x][y],visit);
        DFS(x+1,y,matrix,matrix[x][y],visit);
        DFS(x,y-1,matrix,matrix[x][y],visit);
        DFS(x,y+1,matrix,matrix[x][y],visit);
    }
    
    */
    