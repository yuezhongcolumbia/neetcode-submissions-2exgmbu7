class Solution {
    public int minCostConnectPoints(int[][] points) {
        Map<Integer,List<int[]>>adj = new HashMap<>();
        Set<Integer>visit = new HashSet<>();
        int size = points.length;
        for(int i =0; i < size; i ++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            for(int j = i+1; j<size; j++){
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dist = Math.abs(x1-x2)+Math.abs(y1-y2);
                adj.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[]{dist,j});
                adj.computeIfAbsent(j,k -> new ArrayList<>()).add(new int[]{dist, i});
            }
        }
        int res = 0;
        PriorityQueue<int[]>minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        minHeap.offer(new int[]{0,0});
        while(!minHeap.isEmpty()){
            int[]curr = minHeap.poll();
            int point = curr[1];
            int dist = curr[0];
            if(visit.contains(point)){
                continue;
            }
            visit.add(point);
            res += dist;
            
            for(int[]neigh: adj.getOrDefault(point, new ArrayList<>())){
                
                int next_point = neigh[1];
                int next_dist = neigh[0];
                if(!visit.contains(next_point)){
                    minHeap.offer(new int[]{next_dist,next_point});
                }

            }



        }
        return res;
    }
}
