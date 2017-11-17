    // 713. Subarray Product Less Than K

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k < 2) return 0;
        int l = 0, r = 0, res = 0, mul = 1;
        while (r < nums.length) {
            mul *= nums[r ++];
            while (mul >= k)
                mul /= nums[l ++];
            res += r - l;
        }
        return res;
    }