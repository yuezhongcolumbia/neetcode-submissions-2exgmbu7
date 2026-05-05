class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> visit = new HashSet<>();
        for (int num: nums){
            set.add(num);
        }
        int res = 0;
        for(int num: nums){
            if (!set.contains(num - 1) && !visit.contains(num)){
                visit.add(num);
                int head = num;
                int seqLen = 1;
                while (set.contains(head + 1)){
                    head++;
                    seqLen++;
                }
                res = Math.max(res, seqLen);
            }
        }
        return res;
    }
}
