    // 523. Continuous Subarray Sum

    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length < 2) return false;
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, -1);
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if(k != 0) sum %= k;  // conor case k =0 
            if(map.containsKey(sum)) {
                if(i - map.get(sum) > 1)
                    return true;
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }