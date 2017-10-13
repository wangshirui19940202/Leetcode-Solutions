    // 39. Combination Sum

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList();
        backtrack(candidates, target, 0, res, new LinkedList());
        return res;
    }
    
    private void backtrack(int[] nums, int target, int cur, List<List<Integer>> res, LinkedList<Integer> list) {
        if (cur == nums.length || target < 0) return;
        if (target == 0) {
            res.add(new LinkedList(list));
            return;
        }
        for (int i = cur; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(nums, target - nums[i], i, res, list); //pass i into next recursion, not i + 1, to test duplicate cases
            list.removeLast();
        }
    }