class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int curr_min = nums[0];
        int global_min = nums[0];
        int total_sum = nums[0];
        int curr_max = nums[0];
        int global_max = nums[0];
        if(nums.length==1){
            return nums[0];
        }
        for(int i = 1; i < nums.length; i ++){
            curr_min = Math.min(curr_min+nums[i],nums[i]);
            global_min = Math.min(global_min,curr_min);
            curr_max = Math.max(curr_max+nums[i],nums[i]);
            global_max = Math.max(global_max,curr_max);
            total_sum += nums[i];
        }
        return (global_max<0)?global_max:Math.max(global_max, total_sum-global_min);
    }
}