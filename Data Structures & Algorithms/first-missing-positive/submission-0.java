class Solution {
    public int firstMissingPositive(int[] nums) {
        //initialize
        int r = 0, n = nums.length;
        //why while here?
        while (r < n){
            //let element out of the range [1, length + 1] remain untouched
            //for now, we deal with other elements first
            if (nums[r] <= 0 || nums[r] > n){
                r++;
                continue;
            }
            
            //making the swap if the element is inside the range
            int index = nums[r] - 1;
            if (nums[r] != nums[index]){
                int temp = nums[r];
                nums[r] = nums[index];
                nums[index] = temp;
            } else {
                //the reason only incremeent 
                r++;
            }
        }
        for (int i = 0; i < n; i++){
            if (nums[i] != i + 1){
                return i + 1;
            }
        }
        //why
        return n+1;
        
    }
}