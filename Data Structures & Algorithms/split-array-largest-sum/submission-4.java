class Solution {
    public int splitArray(int[] nums, int k) {
        // 1.problem:
        //     split into k subarray
        //     non empty
        //     minimize the maximum sum of subarray
        //     return the sum

        //     2,4,10,2 k=2 -> 12

        //     time complexity of dp? O(NK)? seems doable

        //     a partitioning problem. if using binary search, we can set a threshold to see if we can
        //     partition the array into less than equal to k, we can tighten the threshold, maximum decrease
        //     if we need to partition the array into greater than k to achieve this maximum, the threshold needs
        //     to be relaxed, or maximum increased
        
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num: nums){
            max = Math.max(max, num);
            sum += num;
        }

        int l = max, r = sum;
        int res = -1;
        while (l <= r){
            int m = (l + r) >> 1;
            if (feasible(nums, m, k)){
                res = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return res;
    }
    public boolean feasible(int[] nums, int threshold, int k){
        int count = 1;
        int curSum = 0;
        for (int num: nums){
            curSum += num;
            if (curSum > threshold){
                curSum = num;
                count++;
            }
            if (count > k) return false;
        }
        return true;
    }
}