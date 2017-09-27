    // 44. Wildcard Matching

    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        char[] ss = s.toCharArray(), ps = p.toCharArray();
        dp[0][0] = true;
        for(int i = 0; i < p.length(); i++)
            if(ps[i] == '*') dp[0][i + 1] = true;
            else break;
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j < p.length(); j++) {
                if(ss[i] == ps[j] || ps[j] == '?') 
                    dp[i + 1][j + 1] = dp[i][j];
                else if(ps[j] == '*'){
                    dp[i + 1][j + 1] = dp[i][j + 1] || dp[i][j] || dp[i + 1][j];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
    /*
    public boolean isMatch(String s, String p) {
        if(p.equals("*")) return true;
        char[] ss = s.toCharArray(), ps = p.toCharArray();
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for(int i = 0; i<p.length(); i++)
            if(ps[i] == '*')
                dp[0][i+1] = true;
            else break;
        
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < p.length(); j++){
                if(ps[j] == '?' || ps[j] == ss[i]) dp[i+1][j+1]=dp[i][j];
                else if(ps[j]=='*'){
                    dp[i+1][j+1] = dp[i][j]||dp[i][j+1]||dp[i+1][j];  
                    //ss[i-1] == ps[j-1] 前一组 s=p，当前s 是'*'的第一个
                    //ss[i-1]==ps[j]='*' 前一个s在'*'中 
                    //ss[i]=ps[j-1]      当前'*'为空，
                }
                // 不可 else break;
            }
        }
        return dp[s.length()][p.length()];
    }
    */