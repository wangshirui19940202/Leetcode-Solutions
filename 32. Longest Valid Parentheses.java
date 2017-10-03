    // 32. Longest Valid Parentheses

    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        char[] ss = s.toCharArray();
        int res = 0;
        for(int i = 1; i < s.length(); i++) {
            if(ss[i] == '(') dp[i] = 0;
            else if(ss[i - 1] == '(') dp[i] = i - 2 >= 0 ? dp[i - 2] + 2 : 2;
            else {
                if(i - 1 - dp[i - 1] >= 0 && ss[i - 1 - dp[i - 1]] == '(')
                    dp[i] = dp[i - 1] + 2 + (i - 2 - dp[i - 1] >= 0 ?  dp[i - 2 - dp[i - 1]] : 0);
                else
                    dp[i] = 0;
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }