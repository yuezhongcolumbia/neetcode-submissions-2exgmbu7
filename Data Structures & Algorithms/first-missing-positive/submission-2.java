class Solution {
    public int firstMissingPositive(int[] nums) {
        // cyclical sort, ignore 
        int i = 0;
        int n = nums.length;
        while(i < n){
            // if (out of bound and negative or zero) skip
            if (nums[i] <= 0 || nums[i] > n){
                i++;
                continue;
            }
            int destIdx = nums[i] - 1;
            // if (not at its place) swap it to place
            if (nums[i] - 1 != i){
                int tmp = nums[i];
                nums[i] = nums[destIdx];
                nums[destIdx] = tmp;
            }

            // increment only when the element at the dest place is the same OR
            // this place has the right element
            if (nums[i] == nums[destIdx] || nums[i] == i + 1){
                i++;
            }
        }
        for (int j = 0; j < n; j++){
            if (nums[j] != j + 1) return j + 1;
        }
        return n + 1;
    }
}