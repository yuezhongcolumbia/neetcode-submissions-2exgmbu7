class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][]dp = new boolean[n][n];
        for(int i = 0; i< n;i++){
            dp[i][i]=true;
        }
        int count = n;
        for(int i = 1; i<n;i++){
            for(int row = 0; row<n-i; row++){
                int col = row+i;
                if(s.charAt(row)==s.charAt(col)&&(dp[row+1][col-1]||i==1)){
                    dp[row][col]=true;
                    count++;
                }
            }
        }
        return count;
    }
}
