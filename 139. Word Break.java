    // 139. Word Break    
    
    /*
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hash = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        char[] ss = s.toCharArray();
        for(int i = 1; i<=ss.length; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && hash.contains(new String(ss, j, i-j))){
                    dp[i] =true;
                    break;
                }
            }
        }
        return dp[ss.length];
    }
    */
    
    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s.toCharArray(), 0, new HashSet(wordDict), new HashSet());
    }
    private boolean dfs(char[] ss, int cur, HashSet<String> dict, HashSet<Integer> visit) {
        if (cur == ss.length) return true;
        if (visit.contains(cur)) return false;
        for (int i = cur + 1; i <= ss.length; i++) {
            String t = new String(ss, cur, i - cur);
            if (dict.contains(t)) 
                if(dfs(ss, i, dict, visit))
                    return true;
        }
        visit.add(cur);
        return false;
    }
    
    /*
    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s, new HashSet<>(wordDict), new HashSet<String>());
    }
    private boolean dfs(String s, HashSet<String> dict, HashSet<String> visit){
        if(visit.contains(s)) 
            return false;
        if(s.length() == 0)
            return true;
        for(int i = 1; i<=s.length(); i++){
            String cur = s.substring(0, i);
            if(dict.contains(cur) && dfs(s.substring(i), dict, visit))
                return true;
        }
        visit.add(s);
        return false;
    }
    */
    