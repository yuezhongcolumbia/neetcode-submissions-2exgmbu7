class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        if (k == 0){
            return;
        }
        int l = 0, r = n - 1;
        reverse(nums, l, r);
        reverse(nums, 0, k - 1);
        reverse(nums, k, r);
        return;
    }
    public void reverse(int[] nums, int l, int r){
        while (l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
        return;
    }
}