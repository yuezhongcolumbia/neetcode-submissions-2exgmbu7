class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //hashmap counting
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num: nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        //heap
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (Map.Entry<Integer, Integer> entry: count.entrySet()){
            maxHeap.offer(new int[]{entry.getValue(), entry.getKey()});
        }
        //update res
        int[] res = new int[k];
        for (int i = 0; i < k; i++){
            res[i] = maxHeap.poll()[1];
        }
        return res;
    }
}
