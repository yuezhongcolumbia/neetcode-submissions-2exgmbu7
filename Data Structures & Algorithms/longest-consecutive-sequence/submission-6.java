class Solution {
    // state:
    //     1. head
    //     2. curStreak
    //     3. res
    // transition:
    //     1. i -> n:
    //         if found head{
    //             curStreak = 1
    //             while (head + 1 exist){
    //                 curStreak++
    //                 head++
    //             }
    //             update res
    //         }
    // terminal:
    //     i -> n
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int num: nums){
            set.add(num);
        }
        for (int num: nums){
            if (!set.contains(num - 1)){
                int head = num;
                int curStreak = 1;
                while (set.contains(head + 1)){
                    curStreak++;
                    head++;
                }
                res = Math.max(res, curStreak);
            }
        }
        return res;
    }
}
