class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dfs(dp, n);
        return dp[n] != Integer.MAX_VALUE ? dp[n] : -1;
    }
    public int dfs(int[] dp, int curr){
        if (curr == 0){
            return 0;
        }
       
        if (dp[curr] != 0){
            return dp[curr];
        }
        int res = Integer.MAX_VALUE;
        for(int i = 1; i * i <= curr; i++){
            int next = dfs(dp, curr - i * i);
            
            res = Math.min(res, 1 + next);
        }
        return dp[curr] = res;
    }
}