    // 45. Jump Game II

    public int jump(int[] nums) {
        int res = 0, curMax = 0, lastMax = 0;
        
        for(int i = 0; i < nums.length - 1; i++) {
            curMax = Math.max(curMax, i + nums[i]);
            if(i == lastMax) {
                res++;
                lastMax = curMax;
            }
        }
        return res;
    }