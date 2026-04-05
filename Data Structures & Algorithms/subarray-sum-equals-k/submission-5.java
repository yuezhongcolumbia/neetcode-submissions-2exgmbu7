class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++){
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        int count = 0;
        for (int i = 0; i < prefix.length ; i++){
            for (int j = i + 1; j < prefix.length; j++){
                if (prefix[j] - prefix[i] == k){
                    count++;
                }
            }
        }
        return count;
    }
}