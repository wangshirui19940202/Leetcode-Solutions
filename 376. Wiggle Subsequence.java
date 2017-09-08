    
    //376. Wiggle Subsequence
    // Greedy
    
    public int wiggleMaxLength(int[] nums) {
        if(nums.length <= 1) return nums.length;
        int i = 1;
        while(i != nums.length - 1 && nums[i] == nums[i - 1]) 
            i++;
        boolean up = nums[i] > nums[i - 1] ? true : false;
        int res = 1, last = nums[0];
        for(; i < nums.length; i++){
            if((up && nums[i] > nums[i - 1])||(!up && nums[i] < nums[i - 1])) {
                    up = !up;
                    res++;
            }
            last = nums[i];
        }
        return res;
    }