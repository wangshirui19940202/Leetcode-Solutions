    // 3. Longest Substring Without Repeating Characters

    public int lengthOfLongestSubstring(String s) {
        int[] hash = new int[128];
        char[] ss = s.toCharArray();
        int l = 0, r = 0, res = 0;
        while (r < s.length()) {
            if (hash[ss[r++]] ++ == 0) res = Math.max(res, r - l);
            else {
                while (ss[l] != ss[r - 1]) hash[ss[l ++]] --;
                hash[ss[l ++]] --;
            }
        }
        return res;
    }
    /*
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        char[] ss = s.toCharArray();
        int l=0, r=0, res=0;
        while(r < ss.length){
            if(!set.add(ss[r])){
                res = Math.max(res, set.size());
                while(ss[l]!=ss[r]) {
                    set.remove(ss[l++]);
                }
                l++;
            }
            r++;
        }
        return Math.max(res, set.size());
    }
    */