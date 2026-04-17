class Solution {
    // 1. return index
    // 2. if found, return its index, if not, return the idx of the immdediate right elemnt.
    // 3. sorted
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int res = -1;
        while (l <= r){
            int m = l + (r - l) / 2;
            if (nums[m] == target){
                return m;
            } 
            if (nums[m] > target){
               
                r = m - 1;
            } else if (nums[m] < target){
                l = m + 1;
                 res = m;
            }
        }
        return res + 1;
    }
}