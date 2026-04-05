class Solution {
    int[] nums;
    int[][] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        this.nums = nums;
        dp = new int[n + 1][2];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        return Math.max(dfs(0, 1), dfs(1, 0));
    }
    public int dfs(int i, int flag){
        int n = nums.length;
        if (i >= n || (i == n - 1 && flag == 1)){
            return 0;
        }
        if (dp[i][flag] != -1){
            return dp[i][flag];
        }
        int skip = dfs(i + 1, flag);
        int rob = nums[i];
        if (i == 0){
            rob += dfs(2, 1);
        }else {
            rob += dfs(i + 2, flag);
        }
        return dp[i][flag] = Math.max(rob, skip);


    }
}
