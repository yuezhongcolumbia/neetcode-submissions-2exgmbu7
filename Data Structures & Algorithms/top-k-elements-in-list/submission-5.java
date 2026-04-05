class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num: nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (Map.Entry<Integer, Integer> entry: count.entrySet()){
            int num = entry.getKey();
            int freq = entry.getValue();
            pq.add(new int[]{freq, num});
            if (pq.size() > k) pq.poll();
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++){
            int[] cur = pq.poll();
            res[i] = cur[1];
        }
        return res;
    }
}
