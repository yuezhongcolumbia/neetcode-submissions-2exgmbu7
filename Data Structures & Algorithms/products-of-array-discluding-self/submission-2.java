class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftProd = new int[n];
        int[] rightProd = new int[n];
        leftProd[0] = 1;
        rightProd[n - 1] = 1;
        for (int i = 1; i < n; i++){
            leftProd[i] = leftProd[i - 1] * nums[i - 1];
        }
        for (int i = n - 2; i >= 0; i--){
            rightProd[i] = rightProd[i + 1] * nums[i + 1];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++){
            res[i] = leftProd[i] * rightProd[i];
        }
        return res;
    }
}  
