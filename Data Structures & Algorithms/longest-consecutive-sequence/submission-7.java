class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums){
            set.add(num);
        }
        Map<Integer, Integer> count = new HashMap<>();
        for (int num: set){
            if (!set.contains(num - 1)){
                count.put(num, 0);
                int cur = num;
                while(set.contains(cur)){
                    cur++;
                }
                count.put(num, cur - num);
            }
        }
        int res = 0;
        for (int num: count.values()){
            res = Math.max(res, num);
        }
        return res;
    }
}
