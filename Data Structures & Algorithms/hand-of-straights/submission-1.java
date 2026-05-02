class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        // edge case: if not module of groupSize return false;

        // 1,2,4,2,3,5,3,4 -> 1,2,2,3,3,4,4,5
        // sort  vs not sort? sort
        // 1. the first head is the first element

        // where is the second head?
        // the first elemnt that is left

        // we want to keep track of head?
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num: hand){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        Arrays.sort(hand);
        for (int num: hand){
            if (freq.get(num) > 0){
                for (int i = num; i < num + groupSize; i++){
                    if (!freq.containsKey(i) || freq.get(i) == 0) return false;
                    freq.put(i, freq.get(i) - 1);
                }
            }
        }
        return true;


        
    }
}
