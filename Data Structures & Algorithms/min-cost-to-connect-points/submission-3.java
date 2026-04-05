class Solution {
    public int minCostConnectPoints(int[][] points) {
        //build adj
        int n = points.length;
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++){
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                adj.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[]{j, dist});
                adj.computeIfAbsent(j, k -> new ArrayList<>()).add(new int[]{i, dist});
            }
        }
        //minheap
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.add(new int[]{0, 0});
        //visit
        List<Integer> visit = new ArrayList<>();
        int totalCost = 0;
        while(visit.size() < n){
            // pop
            // check visited
            // update res
            // add visited
            int[] cur = minHeap.poll();
            int cost = cur[0];
            int idx = cur[1];
            if (visit.contains(idx)) continue;
            visit.add(idx);
            totalCost += cost;
            for (int[] nei: adj.get(idx)){
                int neiIdx = nei[0];
                int neiDist = nei[1];
                if (!visit.contains(neiIdx)){
                    minHeap.add(new int[]{neiDist, neiIdx});
                }
                
            }
        }
        return totalCost;
    }
}
