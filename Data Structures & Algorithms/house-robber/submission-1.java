class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        return dfs(nums, dp, 0);
    }
    public int dfs(int[] nums, int[] dp, int currHouse){
        if (currHouse > nums.length){
            return 0;
        }
        if (dp[currHouse] != 0){
            return dp[currHouse];
        }
        int res = 0;
        if (currHouse == 0){
            for(int i = 0; i < nums.length; i++){
                res = Math.max(res, nums[i] + dfs(nums, dp, i + 1));
            }
        }else{
            for(int i = currHouse + 1; i < nums.length; i++){
                res = Math.max(res, nums[i] + dfs(nums, dp, i + 1));
            }
        }
        return dp[currHouse] = res;
    }
}
