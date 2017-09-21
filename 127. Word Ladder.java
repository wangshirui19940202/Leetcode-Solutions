    // 127. Word Ladder

    // two end bfs
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hash = new HashSet(wordList);
        if(!hash.contains(endWord)) return 0;
        HashSet<String> beginSet = new HashSet(), endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int res = 1;
        while(!beginSet.isEmpty()){
            res++;
            HashSet<String> temp = new HashSet();
            for(String s : beginSet) {
                char[] ss = s.toCharArray();
                for(int i = 0; i < ss.length; i++) {
                    char o = ss[i];
                    for(char a = 'a'; a <= 'z'; a++) {
                        ss[i] = a;
                        String next = new String(ss);
                        if(endSet.contains(next))
                            return res;
                        if(hash.contains(next)){
                            temp.add(next);
                            hash.remove(next);
                        }
                    }
                    ss[i] = o;
                }
            }
            beginSet = temp;
            if(beginSet.size() > endSet.size()) {
                HashSet<String> exchange = endSet;
                endSet = beginSet;
                beginSet = exchange;
            }
        }
        return 0;
    }
    /*
    // one side bfs
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        HashSet<String> hash = new HashSet<>(wordList);
        HashSet<String> visit = new HashSet<>();
        if(!hash.contains(endWord)) return 0;
        queue.add(beginWord);
        visit.add(beginWord);
        int res = 1, size = 0;
        while(!queue.isEmpty()){
            res++;
            size = queue.size();
            for(int j=0; j<size; j++){
                char[] cur = queue.poll().toCharArray();
                for(int i=0; i<cur.length; i++){
                    char o = cur[i];
                    for(char a='a'; a<='z';a++){
                        cur[i] = a;
                        String next = new String(cur);
                        if(hash.contains(next) && visit.add(next)) queue.add(next);
                        if(next.equals(endWord)) return res;
                    }
                    cur[i] = o;
                }
            }
        }
        return 0;
    }
    */
    
    
    
    /*
    // dfs tle
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hash = new HashSet<>(wordList);
        if(!hash.contains(endWord)) return 0;
        int res = dfs(hash, new HashSet<String>(), beginWord, endWord);
        return res == Integer.MAX_VALUE? 0:res;
    }
    private int dfs(HashSet<String> hash, HashSet<String> visit, String cur, String target){
        if(visit.contains(cur)) return Integer.MAX_VALUE;
        if(target.equals(cur)) return 1;
        visit.add(cur);
        int res = Integer.MAX_VALUE;
        char[] cs = cur.toCharArray();
        for(int i=0; i<cur.length(); i++){
            char o = cs[i];
            for(char a='a'; a<='z';a++){
                cs[i] = a;
                String next = new String(cs);
                if(hash.contains(next)) 
                    res = Math.min(res, dfs(hash, visit, next, target));  
            }
            cs[i] = o;
        }
        visit.remove(cur);
        return res==Integer.MAX_VALUE? res:res+1;
    }
    */
