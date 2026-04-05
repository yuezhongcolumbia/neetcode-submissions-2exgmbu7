class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        return;
    }
    public void reverse(int[] input, int l, int r){
        while (l < r){
            int temp = input[l];
            input[l] = input[r];
            input[r] = temp;
            l++;
            r--;
        }
        return;
    }
}