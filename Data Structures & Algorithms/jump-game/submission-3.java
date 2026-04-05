class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dfs(nums, dp, 0);
       
        return (dp[0] == 1 || dp[1] == 1);
    }
    public int dfs(int[] nums, int[] dp, int i){
        int n = nums.length;
        if (i >= n - 1){
            return dp[i] = 1;
        }
        if (nums[i] == 0){
            return dp[i] = 0;
        }
        if (dp[i] != -1){
            return dp[i];
        }
        int res = 0;
        for (int start = i + 1; start <= Math.min(n, i + nums[i]); start++){
            if (dfs(nums, dp, start) == 1){
                return dp[i] = 1;
            }
        }
        return dp[i] = res;
    }
}
