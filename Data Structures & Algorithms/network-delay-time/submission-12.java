class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // distance, what does distance 
        // pq
        Map<Integer, Integer> distance = new HashMap<>();
        Map<Integer, List<int[]>> adj = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for (int i = 1; i <= n; i++){
            if (i == k){
                distance.put(i, 0);
            } else {
                distance.put(i, Integer.MAX_VALUE);
            }
        }
        for (int[] time: times){
            int node = time[0];
            int dest = time[1];
            int weight = time[2];
            adj.computeIfAbsent(node, key -> new ArrayList<>()).add(new int[]{dest, weight});
        }
        pq.add(new int[]{0, k});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[1];
            int dist = curr[0];
            if (dist> distance.get(node))continue;
            if (adj.containsKey(node)){
                for (int[] nei: adj.get(node)){
                int neighborNode = nei[0];
                int neighborDist = nei[1] + dist;
                //what is this for?
                if (neighborDist > distance.get(neighborNode)) continue;
                distance.put(neighborNode, neighborDist);
                pq.add(new int[]{neighborDist, neighborNode});
            }
            }
            
        }
        int res = 0;
        for (Integer dist: distance.values()){
            if (dist == Integer.MAX_VALUE){
                return -1;
            }
            res = Math.max(res, dist);
        }
        return res;
    }
}
