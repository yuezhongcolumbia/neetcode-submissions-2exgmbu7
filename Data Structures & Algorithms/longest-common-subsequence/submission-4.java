class Solution {
    int[][] memo;
    String text1;
    String text2;
    public int longestCommonSubsequence(String text1, String text2) {
        this.text1 = text1;
        this.text2 = text2;
        int n1 = text1.length();
        int n2 = text2.length();
        memo = new int[n1 + 1][n2 + 1];
        for(int[] arr: memo){
            Arrays.fill(arr, -1);
        }
        return dfs(0, 0);
    }
    public int dfs(int i, int j){
        if (i == text1.length() || j == text2.length()){
            return 0;
        }
        if (memo[i][j] != -1){
            return memo[i][j];
        }
        int res = 0;
        if (text1.charAt(i) == text2.charAt(j)){
            res = 1 + dfs(i + 1, j + 1);
        } else {
            res = Math.max(dfs(i + 1, j),
                dfs(i, j + 1));
        }
        return memo[i][j] = res;
    }
}
