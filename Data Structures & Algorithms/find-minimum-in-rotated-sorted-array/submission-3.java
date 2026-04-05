class Solution {
    public int findMin(int[] nums) {
        int l = 0,  r = nums.length - 1;
        int border = nums[r];
        int res = -1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (nums[mid] <= border){
                r = mid - 1;
                res = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[res];
    }
}
