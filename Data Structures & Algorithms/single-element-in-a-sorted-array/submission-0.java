class Solution {
    public int singleNonDuplicate(int[] nums) {
        // 1. sorted, integers
        // 2. every except one appears twice

        //  0,1,2,3,4,5,6
        //  1,1,2,2,3,5,5

        // the target is different from previous and proceeding element 
        // it has something to do with its index
        // before the target, every element starts with even index, after the target, every element
        // starts with odd index
        int l = 0, r = nums.length - 1;
        while (l < r){
            int m = (l + r) >> 1;
            if (m % 2 != 0){
                m -= 1;
            }
            if (nums[m] == nums[m + 1]){
                l = m + 2;
            } else {
                r = m;
            }
        }
        return nums[l];



    }
}