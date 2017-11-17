    // 679. 24 Game

    public boolean judgePoint24(int[] nums) {        
        return dfs(new double[]{nums[0], nums[1], nums[2], nums[3]});
    }
    private boolean dfs(double[] nums) {
        if (nums.length == 1) return Math.abs(nums[0] - 24) < 0.0000001;
        for (int l = 0; l < nums.length - 1; l++) {
            for (int r = l + 1; r < nums.length; r++) {
                double[] next = new double[nums.length - 1];
                for (int i = 0, p = 0; i < nums.length; i++) 
                    if (i != l && i != r)
                        next[p++] = nums[i];
                next[next.length - 1] = nums[l] + nums[r];
                if (dfs(next)) return true;
                next[next.length - 1] = nums[l] - nums[r];
                if (dfs(next)) return true;
                next[next.length - 1] = nums[r] - nums[l];
                if (dfs(next)) return true;
                next[next.length - 1] = nums[l] * nums[r];
                if (dfs(next)) return true;
                next[next.length - 1] = nums[l] / nums[r];
                if (dfs(next)) return true;
                next[next.length - 1] = nums[r] / nums[l];
                if (dfs(next)) return true;
            }
        }
        return false;
    }
    