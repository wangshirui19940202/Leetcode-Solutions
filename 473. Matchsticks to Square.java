    // 473. Matchsticks to Square

    public boolean makesquare(int[] nums) {
        int sum = 0;
        for(int i : nums)
            sum += i;
        if(sum % 4 != 0 || nums.length < 4) return false;
        int target = sum / 4;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length / 2; i++){
            int t = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = t;
        }
        return backtrack(new int[4], target, nums, 0);
    }
    private boolean backtrack(int[] hash, int target, int[] nums, int cur) {
        if(cur == nums.length)
            if(hash[0] == target && hash[1] == target && hash[2] == target && hash[3] == target)
                return true;
            else return false;
        for(int i = 0; i < 4; i++) {
            int curSum = hash[i] + nums[cur];
            if(curSum <= target){
                hash[i] = curSum;
                if(backtrack(hash, target, nums, cur + 1)) return true;
                hash[i] -= nums[cur];
            }
        }
        return false;
    }
    