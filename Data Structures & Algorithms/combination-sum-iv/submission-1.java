class Solution {
    public int combinationSum4(int[] nums, int target) {
        if(target==0){
            return 1;
        }
        Arrays.sort(nums);
       
        int[] dp = new int[target+1];
        for(int i =1; i < dp.length; i ++){
            for(int j =0; j<nums.length; j++){
                if(nums[j]==i){
                    dp[i]++;
                }
                if(nums[j]>i){
                    break;
                }
                dp[i]+= dp[i-nums[j]];
            }
        }
        return dp[target];
    }
}