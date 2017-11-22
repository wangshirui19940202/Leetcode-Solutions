class Solution {    
    /** 
    * word game
    * input: string, int K
    * output:find the substrs of size K with K distinct chars
    */
    // two pointers, l: first char of the substr, r: l + substr.length
    public List<String> wordGame(String str, int k) {
        List<String> res = new ArrayList();
        int l = 0, r = 0;
        char[] ss = str.toCharArray();
        int[] hash = new int[256];
        int dif = 0; // count of different char
        while (r < str.length()) {
            // window with size K
            while (r - l < k && r < str.length())
                if (hash[ss[r++]] ++ == 0) dif ++;
            if (dif == k) {
                res.add(str.substring(l, r));
                -- hash[ss[l ++]];
                dif --;
            }
            // window moving left edge
            while (dif != r - l) 
                if (-- hash[ss[l ++]] == 0) dif --;
        }
        return res;
    }
    
}