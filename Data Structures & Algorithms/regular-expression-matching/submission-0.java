class Solution {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        Boolean[][] dp = new Boolean[sLen + 1][pLen + 1];
        return dfs(0, 0, s, p, sLen, pLen, dp);
    }
    public boolean dfs(int i, int j, String s, String p, int sLen, int pLen, Boolean[][] dp){
        if (j == pLen){
            return i == sLen;
        } 
        if (dp[i][j] != null){
            return dp[i][j];
        }

        boolean match = i < sLen && (s.charAt(i) == p.charAt(j) || (p.charAt(j) == '.'));

        if (j + 1 < pLen && p.charAt(j + 1) == '*'){
            dp[i][j] = ( match && dfs(i+1, j, s, p, sLen, pLen, dp) ) || dfs(i, j+2, s, p, sLen, pLen, dp);
        } else {
            dp[i][j] = match && dfs(i+1, j+1, s, p, sLen, pLen, dp);
        }
        return dp[i][j];



    }
}
