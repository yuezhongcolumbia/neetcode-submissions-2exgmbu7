class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2. length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i < m + 1; i++){
            Arrays.fill(dp[i], -1);
        }
        return dfs(text1, text2, dp, m, n );
    }
    public int dfs(String text1, String text2, int[][] dp, int i, int j){
        if (i == 0 || j == 0){
            return 0;
        }
        if (dp[i][j] != -1){
            return dp[i][j];
        }
        if (text1.charAt(i-1) == text2.charAt(j-1)){
            return dp[i][j] = 1 + dfs(text1, text2, dp, i - 1, j - 1);
        }else {
            return dp[i][j] = Math.max(dfs(text1, text2, dp, i - 1, j),
                                        dfs(text1, text2, dp, i, j - 1));
        }

    }
}
