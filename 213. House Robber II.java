    // 213. House Robber II

    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        
        int res1 = 0, pick = 0, unpick = 0;
        for(int i = 0; i < nums.length - 1; i++){
            int old = pick;
            pick = unpick + nums[i];
            unpick = Math.max(old, unpick);
        }
        res1 = Math.max(pick, unpick);
        
        int res2 = 0;
        pick = 0;
        unpick = 0;
        for(int i = 1; i < nums.length; i++){
            int old = pick;
            pick = unpick + nums[i];
            unpick = Math.max(old, unpick);
        }
        res2 = Math.max(pick, unpick);
        return Math.max(res1, res2);
    }
    