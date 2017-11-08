    // 525. Contiguous Array
    
    public int findMaxLength(int[] nums) {
        int res = 0, sum = 0;
        HashMap<Integer, Integer> hash = new HashMap();
        hash.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0? -1 : 1;
            if (hash.containsKey(sum))
                res = Math.max(res, i - hash.get(sum));
            else
                hash.put(sum, i);
        }
        return res;
    }
    