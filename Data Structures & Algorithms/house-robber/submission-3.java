class Solution {
    int[] dp;
    int[] nums;
    public int rob(int[] nums) {
        int n = nums.length;
        this.nums = nums;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return dfs(0);
    }
    public int dfs(int i){
        int n = nums.length;
        if (i >= n){
            return 0;
        }
        if (dp[i] != -1){
            return dp[i];
        }
        int rob = nums[i] + dfs(i + 2);
        int skip = dfs(i + 1);
        return dp[i] = Math.max(rob, skip);
    }
}
