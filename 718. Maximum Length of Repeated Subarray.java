    // 718. Maximum Length of Repeated Subarray

    public int findLength(int[] A, int[] B) {
        int res = 0; 
        int[][] dp = new int[A.length + 1][B.length + 1];
        for (int i = 0; i < A.length; i ++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] == B[j]) dp[i + 1][j + 1] = 1 + dp[i][j];
                else dp[i + 1][j + 1] = 0;
                res = Math.max(res, dp[i + 1][j + 1]);
            }
        }
        return res;
    }