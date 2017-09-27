    // 310. Minimum Height Trees

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) return Collections.singletonList(0);
        ArrayList<HashSet<Integer>> map = new ArrayList();
        for (int i = 0; i < n; i++) map.add(new HashSet());
        for (int[] i : edges) {
            map.get(i[0]).add(i[1]);
            map.get(i[1]).add(i[0]);
        }
        ArrayList<Integer> leaves = new ArrayList();
        for (int i = 0; i < n; i++) 
            if(map.get(i).size() == 1)
                leaves.add(i);
        while (n > 2) {
            n -= leaves.size();
            ArrayList<Integer> next = new ArrayList();
            for(int i : leaves){
                int node = map.get(i).iterator().next();
                map.get(node).remove(i);
                if(map.get(node).size() == 1)
                    next.add(node);
            }
            leaves = next;
        }
        return leaves;
    }
    /*
    // stack overflow
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        HashMap<Integer, Integer> map=new HashMap();
        ArrayList<LinkedList<Integer>> hash=new ArrayList();
        for(int i=0;i<n;i++) hash.add(new LinkedList<Integer>());
        for(int [] t: edges){
            hash.get(t[0]).add(t[1]);
            hash.get(t[1]).add(t[0]);
        }
        int count=Integer.MAX_VALUE;
        List<Integer> res=new LinkedList<>();
        for(int i=0;i<n;i++){
            int cur=dfs(i, hash, -1, map);
            if(cur<count){ 
                res=new LinkedList();
                count=cur;
            }
            if(cur==count) res.add(i);
        }
        return res;
    }
    private int dfs(int c, ArrayList<LinkedList<Integer>> hash, int last, HashMap<Integer, Integer> map){
        if(map.containsKey(c)) return map.get(c);
        LinkedList<Integer> cur=hash.get(c);
        int res=0;
        for(int i:cur){
            if(last!=i)
                res=Math.max(res,dfs(i, hash, c, map));
        }
        map.put(c, res+1);
        return res+1;
    }
    */
    