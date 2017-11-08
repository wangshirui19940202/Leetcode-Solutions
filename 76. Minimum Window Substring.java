    // 76. Minimum Window Substring

    public String minWindow(String s, String t) {
        int[] target = new int[128];
        for (char c : t.toCharArray()) target[c] ++;
        int l = 0, r = 0, count = t.length(), length = Integer.MAX_VALUE, start = 0;
        char[] ss = s.toCharArray();
        while (r < s.length()) {
            if (target[ss[r ++]] -- > 0) count --;
            while (count == 0) {
                if (length > r - l + 1) {
                    length = r - l + 1;
                    start = l;
                }
                if (target[ss[l ++]] ++ == 0) count++;
            }
        }
        return length == Integer.MAX_VALUE ? "" : s.substring(start, start + length - 1);
    }