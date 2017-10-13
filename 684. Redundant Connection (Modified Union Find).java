    // 684. Redundant Connection
    // modified union find

    class UnionFind {
        public int[] parents, rank;
        public int size;
        
        public UnionFind(int size) {
            this.size = size;
            this.parents = new int[size + 1];
            this.rank = new int[size + 1];
            for (int i = 1; i <= size; i++)
                parents[i] = i;
        }
        public int find(int i){
            while (parents[i] != i) {
                parents[i] = parents[parents[i]];
                i = parents[i];
            }
            return i;
        }
        public boolean union(int l, int r){
            int pl = find(l), pr = find(r);
            if (pl == pr) return false;
            if (rank[pl] > rank[pr]) {
                parents[pr] = parents[pl];
                rank[pl] ++;
            } else {
                parents[pl] = parents[pr];
                rank[pr] ++;
            }
            return true;
        }
        
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);
        for (int[] i : edges) {
            if (!uf.union(i[0], i[1]))
                return i;
        }
        return null;
    }