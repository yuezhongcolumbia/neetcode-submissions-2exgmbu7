//1. interval DP
//2. dp[l][r] represents max gain popping all the balloons from l to r
//3. choices: for loop -> choose the last balloon to pop
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        return dfs(nums, dp, 0, n - 1);
    }
    
    public int dfs(int[] nums, int[][] dp, int l, int r){
        int n = nums.length;
        //base?
        if (l > r){
            return 0;
        }
        
        if (dp[l][r] != 0){
            return dp[l][r];
        }
        //this would be the multiplier for the last balloon to pop
        int leftMultiplier = (l == 0 ? 1 : nums[l - 1]);
        int rightMultiplier = (r == n - 1 ? 1 : nums[r + 1]);
        //for loop to choose the last balloon
        for(int i = l; i <= r; i++){
            dp[l][r] = Math.max(dp[l][r], dfs(nums, dp, l, i - 1) + 
                                dfs(nums, dp, i + 1, r) + 
                                leftMultiplier * nums[i] * rightMultiplier);
        }
        return dp[l][r];

    }
}
