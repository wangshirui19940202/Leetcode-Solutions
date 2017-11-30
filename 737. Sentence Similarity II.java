class Solution {
    // 737. Sentence Similarity II
    // dfs bfs UnionFind
    
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;
        HashMap<String, ArrayList<String>> map = new HashMap();
        for (String[] p : pairs) {
            if (!map.containsKey(p[0])) map.put(p[0], new ArrayList());
            if (!map.containsKey(p[1])) map.put(p[1], new ArrayList());
            map.get(p[0]).add(p[1]);
            map.get(p[1]).add(p[0]);
        }
        for (int i = 0; i < words1.length; i++) 
            if (!doublebfs(words1[i], words2[i], map)) 
                return false;
        return true;
    }
    private boolean doublebfs(String l, String r, HashMap<String, ArrayList<String>> pairs) {
        if (l.equals(r)) return true;
        if (!pairs.containsKey(l) || !pairs.containsKey(r)) return false;
        HashSet<String> visit = new HashSet();
        HashSet<String> lset = new HashSet();
        HashSet<String> rset = new HashSet();
        lset.add(l);
        rset.add(r);
        visit.add(l);
        visit.add(r);
        while (!lset.isEmpty()) {
            HashSet<String> next = new HashSet();
            for (String cur : lset) 
                for (String n : pairs.get(cur)) {
                    if (rset.contains(n)) return true;
                    if (visit.contains(n)) continue;
                    next.add(n);
                    visit.add(n);
                }
            lset = next;
            if (lset.size() > rset.size()) {
                HashSet<String> temp = lset;
                lset = rset;
                rset = temp;
            }
        }
        return false;
    }
    
    /*
    class UnionFind {
        HashMap<String, String> parent;
        HashMap<String, Integer> rank;
        
        public UnionFind (String[][] pair) {
            parent = new HashMap();
            rank = new HashMap();
            for (String[] p : pair) {
                parent.put(p[0], p[0]);
                parent.put(p[1], p[1]);
                rank.put(p[0], 0);
                rank.put(p[1], 0);
            }
        }
        
        public String find(String s) {
            if (!rank.containsKey(s)) return s;
            String cur = new String(s);
            while (!cur.equals(parent.get(cur)) ) {
                parent.put(cur, parent.get(parent.get(cur)) );
                cur = parent.get(cur);
            }
            return parent.get(cur);
        }
        
        public void union(String l, String r) {
            String lp = find(l), rp = find(r);
            if (lp.equals(rp)) return;
            else if (rank.get(lp) > rank.get(rp)) {
                parent.put(rp, lp);
            } else {
                parent.put(lp, rp);
                rank.put(rp, rank.get(rp) + 1);
            }
        }
        
    }
    
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;
        UnionFind uf = new UnionFind(pairs);
        for (String[] p : pairs) uf.union(p[0], p[1]);
        
        HashMap<String, Integer> parent1 = new HashMap();
        HashMap<String, Integer> parent2 = new HashMap();
        
        for (String s : words1) {
            String curp = uf.find(s);
            parent1.put(curp, parent1.getOrDefault(curp, 0) + 1);
        }
        for (String s : words2) {
            String curp = uf.find(s);
            parent2.put(curp, parent2.getOrDefault(curp, 0) + 1);
        }
        
        for (Map.Entry<String, Integer> entry : parent1.entrySet())
            if (entry.getValue() != parent2.get(entry.getKey()))
                return false;
        return true;
    }
    */
    
    
}