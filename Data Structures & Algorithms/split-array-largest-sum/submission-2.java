class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int[][] dp =  new int[n + 1][k + 1];
        for (int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        return dfs(nums, dp, k, 0);
    }
    public int dfs(int[] nums, int[][] dp, int k, int i){
        int n = nums.length;
        //base, k = 0 i!=0, k!=0 i = n, max
        if ((k == 0 && i != n) || (k != 0 && i == n)){
            return Integer.MAX_VALUE;
        }
        //base, k=0 i=0 return 0 
        if (k == 0 && i == n){
            return 0;
        }
        //memoization
        if (dp[i][k] != -1) {
            return dp[i][k];
        }
        int res = Integer.MAX_VALUE;
        int curSum = 0;
        for(int j = i; j < n; j++){
            curSum += nums[j];
            //update res
            res = Math.min(res, Math.max(curSum, dfs(nums, dp, k - 1, j + 1)));
        }
        return dp[i][k] = res;
    }
}