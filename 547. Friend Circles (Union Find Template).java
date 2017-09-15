    // 547. Friend Circles
    // Union Find Template

    class UnionFind {
        int n, count;
        int[] parent, rank;
        
        public UnionFind(int n) {
            this.n = n;
            count = n;
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++)
                parent[i] = i;
        }
        
        private int find(int c) {
            while(parent[c] != c) {
                parent[c] = parent[parent[c]];
                c = parent[c];
            }
            return c;
        }
        
        public void union(int l, int r) {
            int parentl = find(l), parentr = find(r);
            if(parentl == parentr) return;
            if(rank[parentl] > rank[parentr]){
                parent[parentr] = parentl;
            }
            else {
                parent[parentl] = parentr;
                if(rank[parentr] == rank[parentl])
                    rank[parentr] ++;
            }
            count--;
        }
    }
    
    public int findCircleNum(int[][] M) {
        if(M.length == 0) return 0;
        UnionFind uf = new UnionFind(M.length);
        for(int i = 0; i < M.length; i++) 
            for(int j = 0; j < M.length; j++)
                if(M[i][j] == 1)
                    uf.union(i, j);
        return uf.count;
    }
    
    /*
    public int findCircleNum(int[][] M) {
        int res = 0;
        boolean[] visit = new boolean[M.length];
        for(int i = 0 ; i < M.length ; i++){
            if(!visit[i]){
                res++;
                dfs(visit, M, i);
            }        
        }
        return res;
    }
    
    private void dfs(boolean[] visit, int[][] M, int cur){
        visit[cur] = true;
        for(int i = 0 ; i<visit.length ; i++)
            if(M[cur][i] == 1 && !visit[i])
                dfs(visit, M, i);
    }
    */