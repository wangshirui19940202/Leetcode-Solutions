    //301. Remove Invalid Parentheses
    //bfs
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList();
        if(s == null) return res;
        Queue<String> queue = new LinkedList();
        HashSet<String> visit = new HashSet();
        queue.add(s);
        while(!queue.isEmpty() && res.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String cur = queue.poll();
                if(check(cur)) {
                    res.add(cur);
                    continue;
                }
                for(int j = 0; j < cur.length(); j++) {
                    if(cur.charAt(j) == ')' || cur.charAt(j) == '(') {
                        String next = cur.substring(0, j) + cur.substring(j + 1);
                        if(visit.add(next))
                            queue.add(next);
                    }
                }
            }
        }
        return res;
    }
    
    private boolean check(String s) {
        int stack = 0;
        for(char c: s.toCharArray())
            if(c == '(')
                stack ++;
            else if (c == ')' && --stack < 0)
                return false;
        return stack == 0;
    }
    
    
    /*
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new LinkedList();
        dfs(res, 0, 0, new char[]{'(',')'}, s);
        return res;
    }
    private void dfs(List<String> res, int istart, int jstart, char[] pair, String cur){
        char[] ss = cur.toCharArray();
        for(int stack = 0, i = istart; i<cur.length(); i++){
            if(ss[i] == pair[0]) stack++;
            else if(ss[i] == pair[1]) stack--;
            if(stack < 0){
                for(int j = jstart; j <=i; j++){
                    if(ss[j]==pair[1]&&(j==jstart||ss[j-1]!=pair[1]))
                        dfs(res, i, j, pair, cur.substring(0, j)+cur.substring(j+1, cur.length()));
                }
                return;
            }
        }
        String reverse = new StringBuilder(cur).reverse().toString();
        if(pair[0]=='(')
            dfs(res, 0, 0, new char[]{')','('}, reverse);
        else
            res.add(reverse);
    }
    */
    