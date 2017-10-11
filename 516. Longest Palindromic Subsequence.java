    // 516. Longest Palindromic Subsequence
    
    public int longestPalindromeSubseq(String s) {
        if (s.length() <= 1) return s.length();
        char[] ss = s.toCharArray();
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
            for (int j = i -1 ; j >= 0; j--) {
                if (ss[i] == ss[j]) dp[j][i] = 2 + dp[j + 1][i - 1];
                else dp[j][i] = Math.max(dp[j + 1][i], dp[j][i - 1]);
            }
        }
        return dp[0][s.length() - 1];
    }
    
    /*
    public int longestPalindromeSubseq(String s) {
        return dp(s.toCharArray(),0,s.length()-1,new int[s.length()][s.length()]);
    }
    
    public int dp(char[] ss, int s, int e, int[][] hash){
        if(s==e) hash[s][s]=1;
        if(s>e || hash[s][e]!=0) return hash[s][e];
        if(ss[s]==ss[e]) hash[s][e] = 2+dp(ss,s+1,e-1,hash);
        else hash[s][e] = Math.max(dp(ss,s+1,e,hash),dp(ss,s,e-1,hash));
        return hash[s][e];
    }
    */
    
    
    /* //bottom up
    public int longestPalindromeSubseq(String s) {
        int length=s.length();
        char[] ss=s.toCharArray();
        int [][] dp=new int[length][length];
        for(int i=length-1;i>=0;i--){
            dp[i][i]=1;
            for(int j=i+1;j<length;j++){
                if(ss[i]==ss[j])
                    dp[i][j]=2+dp[i+1][j-1];
                else
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
            }
        }
        return dp[0][length-1];
    }*/