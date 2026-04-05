class Solution {
    int[] dp;
    String s;
    List<String> wordDict;
    public boolean wordBreak(String s, List<String> wordDict) {
    //   choice:
    //     1. stop here, see if subproblem return true
    //     2. keep going, find another word in dict, see if subproblem return true;

    //  return:
    //     1. true/false

    // base: 
    //     1. till the end, return true
        this.s = s;
        this.wordDict = wordDict;
        int n = s.length();
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return dfs(0);

    }
    public boolean dfs(int i){
        if (i == s.length()){
            return true;
        }
        if (dp[i] != -1){
            return dp[i] == 1 ? true : false;
        }
        for (int j = i; j < s.length(); j++){
            String cur = s.substring(i, j + 1);
            if (wordDict.contains(cur) && dfs( j + 1)){
                dp[i] = 1;
                return true;
            }
        }
        dp[i] = 0;
        return false;
    }
}
