    // 486. Predict the Winner

public class Solution {
    
    // dp bottom up
    // dp[j][i] : nums from j to i
    public boolean PredictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i][i] = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                dp[j][i] = Math.max(nums[i] - dp[j][i - 1], nums[j] - dp[j + 1][i]);
            }
        }
        return dp[0][nums.length - 1] >= 0;
    }
    
    /*
    // dp top down
    // dp[i][j] : nums from i to j
    public boolean PredictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for (int i = dp.length - 1; i >= 0; i--) {
            dp[i][i] = nums[i];
            for (int j = i + 1; j < dp.length; j++) {
                dp[i][j] = Math.max(nums[j] - dp[i][j - 1], nums[i] - dp[i + 1][j]);
            }
        }
        return dp[0][nums.length - 1] >= 0;
    }
    */
    /*
    // dfs with cache
    public boolean PredictTheWinner(int[] nums) {
        int[][] hash = new int[nums.length][nums.length];
        for(int i = 0; i < hash.length; i++)
            for(int j = 0; j < hash[0].length; j++)
                hash[i][j] = Integer.MIN_VALUE;
        return process(nums, 0, nums.length - 1, hash) >= 0 ? true:false;
    }
    
    private int process(int[] nums, int l, int r, int[][] hash){
        if(l > r) return 0;
        if(hash[l][r] == Integer.MIN_VALUE)
            hash[l][r] = Math.max(nums[l] - process(nums, l+1, r, hash), nums[r] - process(nums, l, r-1, hash));
        return hash[l][r];
    }
    */
    
    /*
    // dfs
    public boolean PredictTheWinner(int[] nums) {
        return predict(nums,0,nums.length-1)>=0;
    }
    public int predict(int[]nums,int s,int e){
        if(s==e) return nums[s];
        return Math.max(nums[s]-predict(nums,s+1,e),nums[e]-predict(nums,s,e-1));
    }
    */
}