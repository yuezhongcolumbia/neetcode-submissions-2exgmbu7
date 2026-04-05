class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int leftBound = nums[0], rightBound = nums[nums.length - 1];
        while (l <= r){
            int m = (l + r) / 2;
            if (nums[m] == target){
                return m;
            }
            if (nums[m] >= rightBound){
                if (target < nums[m] && target >= leftBound){
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (target > nums[m] && target <= rightBound){
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;    
    }

}
