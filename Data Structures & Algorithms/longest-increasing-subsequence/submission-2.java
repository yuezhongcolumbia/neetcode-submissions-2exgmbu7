class Solution {
    public int lengthOfLIS(int[] nums) {
        int size = nums.length;
        int[]input = new int[size+1];
        input[size]=Integer.MAX_VALUE;
        for(int i =0;i<size;i++){
            input[i]=nums[i];

        }
        int[]dp = new int[size+1];
        Arrays.fill(dp,-1);
        for(int i =0; i<size+1;i++){
            dfs(input, size,i,dp);
        }
        
        return Arrays.stream(dp).max().getAsInt();
        

    }
    public int dfs(int[]input,int size,int index,int[]dp){
        if(index == size){
            dp[index ]= 0;
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        int curr_maxLis_len = 0;
        for(int i = index+1;i<size+1;i++){
            if(input[i]>input[index]){
                curr_maxLis_len = Math.max(curr_maxLis_len,dfs(input,size,i,dp));
            }
        }
        dp[index] = curr_maxLis_len+1;
        return dp[index];
    }
}
