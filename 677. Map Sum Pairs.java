// 677. Map Sum Pairs

class MapSum {

    class TrieNode {
        int val = 0;
        boolean isWord = false;
        TrieNode[] child;
        public TrieNode() {
            child = new TrieNode[26];
        }
    }
    
    TrieNode root = new TrieNode();
    /** Initialize your data structure here. */
    public MapSum() {
    }
    
    public void insert(String key, int val) {
        TrieNode node = root;
        for(char c : key.toCharArray()) {
            if(node.child[c - 'a'] == null)
                node.child[c - 'a'] = new TrieNode();
            node = node.child[c - 'a'];
        }
        node.val = val;
        node.isWord = true;
    }
    
    public int sum(String prefix) {
        int res = 0;
        TrieNode node = root;
        for(char c : prefix.toCharArray()) {
            if(node.child[c - 'a'] == null) return 0;
            node = node.child[c - 'a'];
        }
        return dfs(node);
    }
    private int dfs(TrieNode node) {
        int res = node.val;
        for(TrieNode c : node.child) {
            if(c != null) {
                res += dfs(c);
            }
        }
        return res;
    }
    
    
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */