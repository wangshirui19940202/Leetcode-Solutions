class WordDictionary {
    // 211. Add and Search Word - Data structure design
    
    private class TrieNode {
        public String word = null;
        public TrieNode[] next;
        public TrieNode() {
            next = new TrieNode[26];
        }
    }
    
    private TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode head = root;
        for (char c : word.toCharArray()) {
            head.next[c - 'a'] = head.next[c - 'a'] == null? new TrieNode() : head.next[c - 'a'];
            head = head.next[c - 'a'];
        }
        head.word = word;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        LinkedList<TrieNode> queue = new LinkedList();
        queue.add(root);
        for (char c : word.toCharArray()) {
            int size = queue.size();
            if (c != '.') {
                for (int i = 0; i < size; i++) {
                    TrieNode next = queue.removeFirst();
                    if (next.next[c - 'a'] != null)
                        queue.add(next.next[c - 'a']);
                }
            } else {
                for (int i = 0; i < size; i++) {
                    TrieNode next = queue.removeFirst();
                    for (int j = 0; j < 26; j++) 
                        if (next.next[j] != null)
                            queue.add(next.next[j]);
                }
            }
            if (queue.size() == 0) return false;
        }
        for (TrieNode n : queue) if (n.word != null) return true;
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */