class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int globMax = nums[0];
        int globMin = nums[0];
        int currMax = 0;
        int currMin = 0;
        int total = 0;
        for(int num: nums){
            total += num;
            currMax = Math.max(currMax + num, num);
            currMin = Math.min(currMin + num, num);
            globMax = Math.max(globMax, currMax);
            globMin = Math.min(currMin, globMin);

        }
        return globMax > 0 ? Math.max(globMax, total - globMin) : globMax;
}
}