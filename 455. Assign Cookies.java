    // 455. Assign Cookies

    public int findContentChildren(int[] g, int[] s) {
        if (g.length == 0 || s.length == 0) return 0;
        Arrays.sort(s);
        Arrays.sort(g);
        int ig = 0;
        for (int i = 0; i < s.length && ig < g.length; i++) {
            if (s[i] >= g[ig])
                ig++;
        }
        return ig;
    }