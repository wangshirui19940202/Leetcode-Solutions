
// N = dict.length  M = letters.length, L = string.length (length of strings in dict)
// without trie, time complexity: O(N*L) (put letters into HashMap<Character, Integer>)
// with trie, time complexity: O(L*M) (search + buildTrie)

// assume 1. all words are lower case 2. no duplicate strings in dict

public class TrieNode {
    String str;  // boolean isWord
    TrieNode[] next;
    public TrieNode () {
        this.next = new TrieNode[26];
    }
    // if contains duplicates, add property: int count;
}
// main function
public List<String> constructWords(String[] dict, String[] letters) {
    TrieNode root = buildTrie(dict);
    HashMap<Character,List<String>> words = new HashMap();
    for (String s : letters) {
        if (s.length() == 0) continue;
        if (!words.containsKey(s.charAt(0))) words.put(s.charAt(0), new ArrayList());
        words.get(s.charAt(0)).add(s);
    }
    HashSet<String> res = new HashSet();
    dfs(words, root, res);
    return new ArrayList<String>(res);
}
// dfs searching
private void dfs(HashMap<Character,List<String>> letters, TrieNode root, HashSet<String> res) {
    if (root.str != null) res.add(root.str);
    for (int i = 0; i < 26; i++) {
        if (root.next[i] != null && letters.containsKey((char)('a' + i)) && letters.get((char)('a' + i)).size() != 0) {
            List<String> curList = letters.get((char)('a' + i));
            for (int j = 0; j < curList.size(); j++) {
                TrieNode next = move(curList.get(j), root);
                if (next == null) continue;
                String removeStr = curList.remove(j);
                dfs(letters, next, res);
                curList.add(j, removeStr);
            }
        }
    }
}
// letters are Strings
private TrieNode move(String str, TrieNode root) {
    if (root == null) return null;
    TrieNode res = root;
    for (char c : str.toCharArray()) {
        if (res.next[c - 'a'] == null) return null;
        res = res.next[c - 'a'];
    }
    return res;
}
// build trie
private TrieNode buildTrie(String[] dict) {
    TrieNode root = new TrieNode();
    for (String s : dict) {
        TrieNode cur = root;
        for (char c : s.toCharArray()) {
            cur.next[c - 'a'] = cur.next[c - 'a'] == null ? new TrieNode() : cur.next[c - 'a'];
            cur = cur.next[c - 'a'];
        }
        cur.str = s;
    }
    return root;
}