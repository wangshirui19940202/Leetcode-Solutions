    // 132. Palindrome Partitioning II

    public int minCut(String s) {
        if (s.length() == 1) return 0;
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[s.length()] = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int l = i, r = i; l >=0 && r < s.length() && s.charAt(l) == s.charAt(r); l--, r++) 
                dp[l] = Math.min(dp[l], dp[r + 1] + 1);
            for (int l = i - 1, r = i; l >=0 && r < s.length() && s.charAt(l) == s.charAt(r); l--, r++) 
                dp[l] = Math.min(dp[l], dp[r + 1] + 1);
        }
        return dp[0] - 1;
    }
    
    /*
    // tle
    public int minCut(String s) {
        return backtrack(s, new HashMap<String, Integer>()) - 1;
    }
    private int backtrack(String s, HashMap<String, Integer> map) {
        if (s.length() == 0) return 0;
        if (map.containsKey(s)) return map.get(s);
        int res = Integer.MAX_VALUE;
        for (int i = s.length(); i > 0; i--) {
            String cur = s.substring(0, i);
            if (check(cur)) {
                res = Math.min(res, 1 + backtrack(s.substring(i), map));
            }
        }
        map.put(s, res);
        return res;
    }
    private boolean check(String s) {
        char[] ss = s.toCharArray();
        for (int l = 0, r = s.length() - 1; l < r; l++, r--) 
            if (ss[l] != ss[r])
                return false;
        return true;
    }
    */