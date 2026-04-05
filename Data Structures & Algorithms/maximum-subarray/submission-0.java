class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][2];
        for(int[] row: dp){
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return dfs(nums, dp, 0, false);
    }
    public int dfs(int[] nums, int[][] dp, int i, boolean flag){
        int n = nums.length;
        if (i == n) {
            return flag ? 0 : (int) -1e6; 
        }
        int f = flag ? 1 : 0;
        if (dp[i][f] != Integer.MIN_VALUE){
            return dp[i][f];
        }
        return flag ? Math.max(0, nums[i] + dfs(nums, dp, i + 1, true)):
            Math.max(dfs(nums, dp, i + 1, false), nums[i] + dfs(nums, dp, i + 1, true));
    }
}
