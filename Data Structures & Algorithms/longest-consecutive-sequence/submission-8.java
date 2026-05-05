class Solution {
    public int longestConsecutive(int[] nums) {
    //     sort
    //    [1,1,2,3,4,7,8,9]
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int seqLen = 1;
            int head = nums[i];
            while (set.contains(head + 1)){
                head++;
                seqLen++;
            }
            res = Math.max(res, seqLen);
        }
        return res;
    }
}
