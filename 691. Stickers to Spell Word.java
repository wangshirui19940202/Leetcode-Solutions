     // 691. Stickers to Spell Word

    public int minStickers(String[] stickers, String target) {
        int[][] dict = new int[stickers.length][26];
        for (int i = 0; i < stickers.length; i++)
            for (char c : stickers[i].toCharArray())
                dict[i][c - 'a'] ++;
        HashMap<String, Integer> map = new HashMap();
        return dfs(target, map, dict);
    }
    private int dfs (String target, HashMap<String, Integer> map, int[][] dict) {
        if (target.equals("")) return 0;
        if (map.containsKey(target)) return map.get(target);
        int res = Integer.MAX_VALUE;
        int[] targets = new int[26];
        for (char c : target.toCharArray()) targets[c - 'a'] ++;
        
        for (int i = 0; i < dict.length; i++) {
            if (dict[i][target.charAt(0) - 'a'] == 0) continue; // speed up by checking the first letter
            StringBuilder sb = new StringBuilder();
            int[] next = new int[26];
            boolean dec = false;
            for (int j = 0; j < 26; j++) {
                int t = targets[j] - dict[i][j];
                if (targets[j] > 0 && dict[i][j] > 0) dec = true;
                next[j] = t < 0 ? 0 : t;
            }
            if (!dec) continue;
            for (int j = 0; j < 26; j++) 
                for (int k = 0; k < next[j]; k++)
                    sb.append((char)(j + 'a'));
            int nextRes = dfs(sb.toString(), map, dict);
            res = nextRes >= 0 ? Math.min(nextRes, res) : res;
        }
        res = res == Integer.MAX_VALUE ? -1: res + 1;
        map.put(target, res);
        return res;
    }