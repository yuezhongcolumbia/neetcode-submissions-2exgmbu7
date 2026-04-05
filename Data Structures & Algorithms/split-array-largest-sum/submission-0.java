class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n + 1][k + 1];
        for (int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        return dfs(nums, dp, 0, k);
    }
    public int dfs(int[] nums, int[][] dp, int i, int k){
        int n = nums.length;
        if (i == n) {
            return k == 0 ? 0 : Integer.MAX_VALUE;
        }
        if (k == 0){
            return Integer.MAX_VALUE;
        }
        if (dp[i][k] != -1){
            return dp[i][k];
        }
        int curSum = 0;
        int res = Integer.MAX_VALUE;
        for (int j = i; j <= n - k; j++ ){
            curSum += nums[j];
            res = Math.min(res, Math.max(curSum, dfs(nums, dp, j + 1, k - 1)));
        }
        return dp[i][k] = res;
    }
}