    // 40. Combination Sum II
    
    // dp, faster than 15%
    // Using HashSet to eliminate duplicates
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        HashSet<List<Integer>>[] dp = new HashSet[target + 1];
        for(int i = 0; i < dp.length; i++)
            dp[i] = new HashSet<List<Integer>>();
        dp[0].add(new ArrayList<>());
        
        for(int i = 0; i < candidates.length; i++) {
            for(int j = target; j >= 1; j--) {
                if(j < candidates[i]) break;
                for(List<Integer> list : dp[j - candidates[i]]) {
                    List<Integer> temp = new ArrayList(list);
                    temp.add(candidates[i]);
                    dp[j].add(temp);
                }
            }
        }
        
        return new LinkedList<List<Integer>>(dp[target]);
    }

    // backtarck
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(candidates);
        backtrack(res, new LinkedList<Integer>(), 0, candidates, target);
        return res;
    }
    private void backtrack(List<List<Integer>> res, LinkedList<Integer> list, int cur, int[] nums, int target) {
        if(target == 0) {
            res.add(new LinkedList<Integer>(list));
            return;
        }
        if(target < 0) return;
        for(int i = cur; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(res, list, i + 1, nums, target - nums[i]);
            list.removeLast();
            while(i != nums.length - 1 && nums[i] == nums[i + 1]) i++;
        }
    }