class Solution {
    public int search(int[] nums, int target) {
        // 1. first condition:
        //     a. sorted vs unsorted:
        //         if (mid >= leftbound) -> sorted from[leftbound, mid]

        //         else -> unsorted from [m + 1, rightbound]
        // 2. second condition see if it is in the sorted part:
        int l = 0, r = nums.length - 1;
        while (l <= r){
            int m = l + (r - l) / 2;
            if (nums[m] == target){
                return m;
            }
            if (nums[m] >= nums[0]){
                //sorted on the left portion
                if (target >= nums[0] && target < nums[m]){
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                //sorted
                if (target > nums[m] && target <= nums[nums.length - 1]){
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;

    }
}
