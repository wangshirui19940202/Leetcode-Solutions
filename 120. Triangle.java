    // 120. Triangle

    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];
        for(int row = triangle.size() - 1; row >= 0; row--) {
            for(int i = 0; i <= row; i++) {
                dp[i] = Math.min(dp[i], dp[i + 1]) + triangle.get(row).get(i);
            }
        }
        return dp[0];
    }