    // 363. Max Sum of Rectangle No Larger Than K

    public int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix.length == 0) return 0;
        int res = Integer.MIN_VALUE;
        int m = matrix.length, n = matrix[0].length;
        for(int left = 0; left < n; left++) {
            int[] sums = new int[m];
            for(int right = left; right < n; right++) {
                for(int i = 0; i < m; i++)
                    sums[i] += matrix[i][right];
                TreeSet<Integer> set = new TreeSet();
                set.add(0);
                int sum = 0;
                for(int i : sums) {
                    sum += i;
                    Integer low = set.ceiling(sum - k);
                    if(low != null) res = Math.max(sum - low, res);
                    set.add(sum);
                }
            }
        }
        return res;
    }