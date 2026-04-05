class Solution {
    public int subarraySum(int[] nums, int k) {
        int curSum = 0;
        int res = 0;
        HashMap<Integer, Integer> prefix= new HashMap<>();
        prefix.put(0, 1);
        for (int num: nums){
            curSum += num;
            int diff = curSum - k;
            res += prefix.getOrDefault(diff, 0);
            prefix.put(curSum, prefix.getOrDefault(curSum, 0) + 1);
        }
        return res;
    }
}