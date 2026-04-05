class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String>set = new HashSet<>();
        for(String str: dictionary){
            set.add(str);
        }
        int size = s.length();
        int[]dp = new int[size+1];
        dp[0]=0;
        for(int i = 1;i<=size;i++){
            dp[i]=dp[i-1]+1;
            for(int j = 0; j<i;j++){
                String sub = s.substring(j,i);
                if(set.contains(sub)){
                    dp[i]=Math.min(dp[j],dp[i]);
                }
            }
        }
        return dp[size];
    }
}