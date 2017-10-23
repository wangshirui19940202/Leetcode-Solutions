    // 524. Longest Word in Dictionary through Deleting

    // without sort: O(N * M)
    // N = d.size(), M = s.length()
    public String findLongestWord(String s, List<String> d) {
        String res = "";
        char[] ss = s.toCharArray();
        for (String cur : d) {
            char[] cs = cur.toCharArray();
            int i1 = 0, i2 = 0;
            while (i1 < ss.length && i2 < cs.length)
                if (ss[i1 ++] == cs[i2]) i2 ++;
            if (i2 == cs.length) {
                if ((cur.length() > res.length()) || (cur.length() == res.length() && res.compareTo(cur) > 0)) 
                    res = cur;
            }
        }
        return res;
    }
    
    
    /*
    // sort: nlogn * M
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, (s1, s2) -> (s1.length() == s2.length() ? s1.compareTo(s2) : s2.length() - s1.length()));
        char[] ss = s.toCharArray();
        for (String cur : d) {
            char[] cs = cur.toCharArray();
            int i1 = 0, i2 = 0;
            while (i1 < ss.length && i2 < cs.length)
                if (ss[i1 ++] == cs[i2]) i2 ++;
            if (i2 == cs.length) return cur;
        }
        return "";
    }
    */