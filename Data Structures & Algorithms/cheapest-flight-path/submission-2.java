class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //build adj
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i, new ArrayList<>());
        }
        for(int[] flight: flights){
            int start = flight[0];
            int dest = flight[1];
            int cost = flight[2];
            adj.get(start).add(new int[]{dest, cost});

        }
        int[][] distance = new int[n][k + 2];//why k + 2
        for (int[] dist: distance){
            Arrays.fill(dist, Integer.MAX_VALUE);
        }
        distance[src][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, src, 0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int cost = cur[0];
            int node = cur[1];
            int stop = cur[2];
            if (node == dst) return cost;
            if (stop == k + 1 || distance[node][stop] < cost) continue;
            for (int[] neighbor: adj.get(node)){
                int dest = neighbor[0];
                int weight = neighbor[1];
                if (cost + weight < distance[dest][stop + 1]){
                    distance[dest][stop + 1] = cost + weight;
                    pq.add(new int[]{cost+weight, dest, stop + 1});
                }
            }
        }
        return -1;
    }
}
