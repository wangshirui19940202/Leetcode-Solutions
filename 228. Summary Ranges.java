    // 228. Summary Ranges

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList();
        for (int i = 0; i < nums.length; i++) {
            int l = i;
            while (i != nums.length - 1 && nums[i + 1] == nums[i] + 1) i++;
            if (l == i)
                res.add(nums[l] + "");
            else 
                res.add(nums[l] + "->" + nums[i]);
        }
        return res;
    }