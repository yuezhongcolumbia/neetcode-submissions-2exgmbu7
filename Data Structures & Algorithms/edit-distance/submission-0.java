class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][]dp = new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            for(int j = 0; j<n+1;j++){
                dp[i][j]= -1;
            }
        }
        return dfs(word1,word2,dp,m,n);
    }
    private static int dfs(String word1, String word2, int[][]dp,int m, int n){
        if(m==0){
            return n;
        }
        if(n==0){
            return m;
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        int replace =(word1.charAt(m-1)!=word2.charAt(n-1))?1:0;   

        dp[m][n] = Math.min(
            replace+dfs(word1,word2,dp,m-1,n-1),
            Math.min(
                1+dfs(word1,word2,dp,m-1,n),
                1+dfs(word1,word2,dp,m,n-1)
            )
        );
        return dp[m][n];
    }
}
