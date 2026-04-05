class Solution {
    public int splitArray(int[] nums, int k) {
        //left and right, left is max, right is Sum
        int l = 0, r = 0;
        for (int num: nums){
            l = Math.max(l, num);
            r += num;
        }
        int res = 0;
        //binary search with feasibility function
        while (l <= r){
            int m = (l + r) / 2;
            if (feasible(nums, m, k)){
                r = m - 1;
                res = m;
            } else {
                l = m + 1;
            }
        }
        return res;
    }
    public boolean feasible(int[] nums, int limit, int k){
        int curSum = 0;
        int subArray = 1;
        for(int i = 0; i < nums.length; i++){
            //update curSum
            curSum += nums[i];
            //if curSum > limit, subarray ++, curSum has to reset here
            if (curSum > limit){
                curSum = nums[i];
                subArray++;
            }
            //if Subarray>k, false
            if (subArray > k) return false;
        }
        return true;
    }
}