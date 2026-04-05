class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        //heap
        if (hand.length % groupSize != 0){
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: hand){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(map.keySet());
        while (!minHeap.isEmpty()){
            int first = minHeap.peek();
            for (int i = first; i < first + groupSize; i++){
                if (!map.containsKey(i)){
                    return false;
                }
                map.put(i, map.get(i) - 1);
                if (map.get(i) == 0){
                    if (i != minHeap.peek()) return false;
                    minHeap.poll();
                }
            }
        }
        return true;

    }
}
