    // 10. Regular Expression Matching
    
    public boolean isMatch(String s, String p) {
        char[] ss = s.toCharArray(), ps = p.toCharArray();
        boolean[][] dp = new boolean[ss.length + 1][ps.length + 1];
        dp[0][0] = true;
        for(int j = 1; j < ps.length; j++)
            dp[0][j + 1] = ps[j] == '*' && dp[0][j - 1];
        
        for(int i = 0; i < ss.length; i++) {
            for(int j = 0; j < ps.length; j++) {
                if(ss[i] == ps[j] || ps[j] == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if(ps[j] == '*') {
                    if(ps[j - 1] == '.' || ps[j - 1] == ss[i])
                        dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1];
                    else  
                        dp[i + 1][j + 1] = dp[i + 1][j - 1]; 
                }
            }
        }
        return dp[ss.length][ps.length];
    }