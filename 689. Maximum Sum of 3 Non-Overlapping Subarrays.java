    // 689. Maximum Sum of 3 Non-Overlapping Subarrays

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] sum = new int[nums.length];
        int s = 0, len = nums.length;
        for (int i = 0; i < k; i++) sum[k - 1] += nums[i];
        for (int i = k; i < nums.length; i++)
            sum[i] = sum[i - 1] - nums[i - k] + nums[i];
        int[][] dp = new int[len][4];
        int[][] index = new int[len][4];
        index[k - 1][1] = k - 1;
        dp[k - 1][1] = sum[k - 1];
        for (int i = k; i < len; i++) {
            for (int j = 1; j < 4; j++) {
                dp[i][j] = dp[i - 1][j];
                index[i][j] = index[i - 1][j];
                int tsum = dp[i - k][j - 1] + sum[i];
                if (tsum > dp[i][j]) {
                    dp[i][j] = tsum;
                    index[i][j] = i;
                }
            }
        }
        int[] res = new int[3];
        res[2] = index[len - 1][3] + 1 - k;
        res[1] = index[res[2] - 1][2] + 1 - k;
        res[0] = index[res[1] - 1][1] + 1 - k;
        return res;
    }
    
    /*
    // tle
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] sum = new int[nums.length];
        int s = 0;
        for (int i = 0; i < k; i++) {
            s += nums[i];
            sum[i] = s;
        }
        for (int i = k; i < nums.length; i++)
            sum[i] = sum[i - 1] - nums[i - k] + nums[i];
        int[] res = new int[3];
        int sumup = -1;
        for (int i = k - 1; i < nums.length - 2 * k; i++) {
            int curi = sum[i];
            for (int j = i + k; j < nums.length - k; j++) {
                int curj = sum[j];
                for (int l = j + k; l < nums.length; l++) {
                    int curl = sum[l];
                    int tsum = curi + curj + curl;
                    if (sumup < tsum) {
                        res[0] = i - k + 1;
                        res[1] = j - k + 1;
                        res[2] = l - k + 1;
                        sumup = tsum;
                    }
                    while (l != nums.length - 1 && nums[l + 1] <= nums[l - k + 1]) l++;
                }
                while (j != nums.length - k - 1 && nums[j + 1] <= nums[j - k + 1]) j++;
            }
            while (i != nums.length - 2 * k - 1 && nums[i + 1] <= nums[i - k + 1]) i++;
        }
        return res;
    }
    */