class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int result = 0;
        for(int num:set){
            if(!set.contains(num-1)){
                int count = 1;
                while(set.contains(num+count)){
                    count++;
                }
                result = Math.max(result,count);
            }
        }
        return result;
    }
}
