class Solution {
    public int uniquePaths(int m, int n) {
        int[]dp = new int[m];
        Arrays.fill(dp,1);
        for(int i = n-2; i>=0; i --){
            for(int j = m-2; j>=0;j--){
                dp[j]+=dp[j+1];
            }
        }
        return dp[0];
    }
}
