class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        int res = 1;
        for (int num: nums){
            if (!set.contains(num - 1)){
                int seq = 1;
                int next = num + 1;
                while (set.contains(next)){
                    seq++;
                    res = Math.max(res, seq);
                    next ++;
                }
            }
        }
        return res;
    }
}
