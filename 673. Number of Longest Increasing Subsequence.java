    // 673. Number of Longest Increasing Subsequence

    public int findNumberOfLIS(int[] nums) {
        int[] count = new int[nums.length], ends = new int[nums.length];
        int res = 0, max_len = 0;;
        for(int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            count[i] = ends[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[j] < cur) {
                    if(ends[j] + 1 == ends[i])
                        count[i] += count[j];
                    else if(ends[j] + 1 > ends[i]) {
                        count[i] = count[j];
                        ends[i] = ends[j] + 1;
                    }
                }
            }
            if (max_len == ends[i])
                res += count[i];
            else if (max_len < ends[i]) {
                max_len = ends[i];
                res = count[i];
            }
        }
        return res;
    }