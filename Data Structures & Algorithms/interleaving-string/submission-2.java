class Solution {
    String s1;
    String s2;
    String s3;
    Boolean[][] memo;
    public boolean isInterleave(String s1, String s2, String s3) {
        // condtion:
        //     1. must interleave
        // what algo:
        //     1. multisequence- > no monotonic condition -> dp
        // 1. return: can substring(i, end), substring(j, end) form s3.substring(i + j, end);
        // 2. choices:
        //     1. try take letter from the first string 1
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        int m = s1.length();
        int n = s2.length();
        memo = new Boolean[m + 1][n + 1];
        if (s1.length() + s2.length() != s3.length()) return false;
        return dfs(0, 0);

    }
    public Boolean dfs(int i, int j){
        if (i == s1.length() && j == s2.length()){
            return true;
        }
        if (memo[i][j] != null){
            return memo[i][j];
        }
        Boolean res = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)){
            res = dfs(i + 1, j);
        }
        if (!res && j < s2.length() && s2.charAt(j) == s3.charAt(i + j)){
            res = dfs(i, j + 1);
        }
        return memo[i][j] = res;
    }
}
