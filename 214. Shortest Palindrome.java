    // 214. Shortest Palindrome

    public String shortestPalindrome(String s) {
        int l = 0;
        for (int r = s.length() - 1; r >= 0; r--)
            if (s.charAt(l) == s.charAt(r)) 
                l++;
        if (l == s.length()) return s;
        String suffix = s.substring(l);
        return new StringBuilder(suffix).reverse().toString() + shortestPalindrome(s.substring(0, l)) + suffix;
    }
    
    /*
    // tle
    public String shortestPalindrome(String s) {
        char[] ss = s.toCharArray();
        int i = ss.length - 1;
        for (; i >= 0; i--) {
            if (ss[i] == ss[0]) {
                int l = 0, r = i;
                while (ss[l] == ss[r] && l < r) {
                    l ++;
                    r --;
                }
                if (l >= r) break;
            }
        }
        StringBuilder sb = new StringBuilder(s.substring(i + 1, s.length())).reverse();
        sb.append(s);
        return sb.toString();
    }
    */