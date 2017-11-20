    // 464. Can I Win
    
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) return true;
        int sum = (maxChoosableInteger + 1) * maxChoosableInteger / 2;
        if (sum < desiredTotal) return false;
        return dfs(desiredTotal, 0, new HashMap(), maxChoosableInteger);
    }
    private boolean dfs(int rem, int choose, HashMap<Integer, Boolean> visit, int pool) {
        if (rem <= 0) return false;
        if (visit.containsKey(choose)) return visit.get(choose);
        for (int i = pool;  i > 0; i--) {
            int mask = 1 << (i - 1);
            if ((choose & mask) != 0) continue;
            if (!dfs(rem - i, choose | mask, visit, pool)) {
                visit.put(choose, true);
                return true;
            }
        }
        visit.put(choose, false);
        return false;
    }
    