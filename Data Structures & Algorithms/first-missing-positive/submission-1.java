class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;
        while(i < n){
            //skip nonpositive and out of bound
            if (nums[i] <= 0 || nums[i] > n){
                i++;
                continue;
            }
            //location where it supposed to be
            int correctIdx = nums[i] - 1;
            //keep swaaping unless the two are the same
            if (nums[i] != nums[correctIdx]){
                int tmp = nums[correctIdx];
                nums[correctIdx] = nums[i];
                nums[i] = tmp;
            }
            //if so proceed
            else {
                i++;
            }
        }
        //loop again to find the real one
        for (int j = 0; j < nums.length; j++){
            if (nums[j] != j + 1){
                return j + 1;
            }
        }
        return n + 1;
    }
}