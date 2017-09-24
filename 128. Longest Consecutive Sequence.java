    // 128. Longest Consecutive Sequence

    public int longestConsecutive(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) continue;
            int l = map.getOrDefault(nums[i] - 1, 0), r = map.getOrDefault(nums[i] + 1, 0), length = 1 + l + r;
            map.put(nums[i], length);
            map.put(nums[i] - l, length);
            map.put(nums[i] + r, length);
            res = Math.max(res, length);
        }
        return res;
    }