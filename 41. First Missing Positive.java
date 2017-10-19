    // 41. First Missing Positive

    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) return 1;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            while (l < nums.length && nums[l] > 0) l++;
            while (r >= 0 && nums[r] <= 0) r--;
            if (l < r) {
                int t = nums[l];
                nums[l] = nums[r];
                nums[r] = t;
            }
        }
        for (int i = 0; i < l; i++) {
            int p = Math.abs(nums[i]);
            if (Math.abs(nums[i]) <= nums.length)
                nums[p - 1] = nums[p - 1] > 0 ? -nums[p - 1] : nums[p - 1];
        }
        int index = 0;
        for (index = 0; index < l; index++)
            if (nums[index] > 0) break;
        return index + 1;
    }