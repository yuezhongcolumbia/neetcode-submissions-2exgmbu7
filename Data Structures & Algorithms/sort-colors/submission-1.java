class Solution {
    public void sortColors(int[] nums) {
        //three pointer
        int i = 0, l = 0, r = nums.length - 1;
        while(i <= r){
            if (nums[i] == 0){
                // swap i, l;
                swap(nums, l, i);
                l++;
            } else if (nums[i] == 2){
                // swap i, r;
                swap(nums, i, r);
                i--;
                r--;
            }
            i++;
        }
    }
    public void swap(int[] nums, int l, int r){
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
}