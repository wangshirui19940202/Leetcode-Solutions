    // 131. Palindrome Partitioning

    // backtrack
    List<List<String>> res = new LinkedList();
    public List<List<String>> partition(String s) {
        backtrack(s, new LinkedList());
        return res;
    }
    private void backtrack(String s, List<String> tlist){
        if(s.equals("")||s.length()==0) return;
        for(int i = 1; i <= s.length(); i++){
            String l = s.substring(0, i);
            if(check(l)){
                tlist.add(l);
                String r = s.substring(i, s.length());
                if(r.length() == 0){
                    res.add(new LinkedList(tlist));
                }
                backtrack(r, tlist);
                tlist.remove(tlist.size() - 1); 
            } 
        }
    }
    private boolean check(String s){
        char[] chars = s.toCharArray();
        int l = 0, h = chars.length - 1;
        while(l <= h){
            if(chars[l] != chars[h]) return false;
            l++;
            h--;
        }
        return true;
    }

    
    /*
    // dp, only check for palindrome, won't update res
    public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList();
        char[] ss = s.toCharArray();
        boolean[][] dp = new boolean[ss.length][ss.length];
        for(int i = ss.length - 1; i >= 0; i--) {
            dp[i][i] = true;
            for(int j = i + 1; j < ss.length; j++)
                if(ss[i] == ss[j])
                    if(j - i <= 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    }
        }
        
        for(int i = 0; i < dp.length; i++){
            System.out.println("");
            for(int j = 0; j < dp.length; j++){
                System.out.print("   " + dp[i][j]);
            }
        }
        return res;
    }
    */