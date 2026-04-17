class Solution {
    public int findMin(int[] nums) {
        
        // example:
        //     3,4,5,6,1,2 if m >= leftBound in sorted part?
        //     1,2,3,4,5,6 
        //     6,1,2,3,4,5
        //     5,6,1,2,3,4
        int l = 0, r = nums.length - 1;
        int rightBound = nums[nums.length - 1];
        int res = -1;
        while (l <= r){
            int m = (l + r) >> 1;
            //first if else locate the sorted part, the target is in the non sorted
            if (nums[m] > rightBound){
                //unsorted part
                l = m + 1;
            } else {
                r = m - 1;
                res = m;
            }
        }
        return nums[res];
    }
}
