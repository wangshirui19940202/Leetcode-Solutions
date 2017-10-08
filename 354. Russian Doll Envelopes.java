    // 354. Russian Doll Envelopes

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) return 0;
        Arrays.sort(envelopes, (int[] a, int[] b) -> {return a[0] == b[0]? b[1] - a[1] : a[0] - b[0];});
        int res = 0;
        int[] dp = new int[envelopes.length];
        for (int[] i : envelopes) {
            int p = Arrays.binarySearch(dp, 0, res, i[1]);
            if (p < 0) p = - p - 1;
            dp[p] = i[1];
            if (p == res) res++;
        }
        return res;
    }
    /*
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) return 0;
        Arrays.sort(envelopes, (int[] a, int[] b) -> {return a[0] - b[0];});
        int res = 0;
        int[] dp = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            for (int j = 0; ; j++) {
                if (envelopes[j][0] == envelopes[i][0]) break;
                if (envelopes[j][1] < envelopes[i][1])
                    dp[i] = Math.max(dp[j], dp[i]);
            }
            dp[i] ++;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    */