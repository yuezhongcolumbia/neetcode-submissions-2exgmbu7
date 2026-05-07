class Solution {
    public void nextPermutation(int[] nums) {
        // 1,2,3 -> 1,3,2 -> 2,1,3 -> 2,3,1 -> 3,1,2 -> 3,2,1 ->1,2,3

        // find the pivot
        // swap the pivot with the next bigger value
        // reverse the right part

        
        int pivot = -1;
        int n = nums.length; 
        if (n == 1) return;
        for (int i = n - 2; i >= 0; i--){
            if (nums[i] >= nums[i + 1]) continue;
            pivot = i;
            int j = pivot + 1;
            while (j < n && nums[j] > nums[pivot]){
                j++;
            }
            swap(nums, pivot, j - 1);
            reverse(nums, pivot + 1, n - 1);
            break;
            
        }
        if (pivot == -1){
            reverse(nums, 0, n - 1);
        }

        


    }
    public void swap(int[] nums, int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
         nums[r] = temp;
    }
    public void reverse(int[] nums, int l, int r){
        while(l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}