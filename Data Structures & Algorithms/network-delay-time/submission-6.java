class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>>adj = new HashMap<>();
        Set<Integer>visit = new HashSet<>();
        for(int[]time:times){
           adj.computeIfAbsent(time[0],key->new ArrayList<>()).add(new int[]{time[1],time[2]}); 
        }
        PriorityQueue<int[]>minHeap = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        minHeap.offer(new int[]{0,k});
        int res=0;
        while(!minHeap.isEmpty()){
            int[]curr = minHeap.poll();
            int cost = curr[0];
            int src = curr[1];
            if(visit.contains(src))continue;
            res = cost;
            visit.add(src);
            
            for(int[]neigh:adj.getOrDefault(src,new ArrayList<>())){
                int next_cost = neigh[1];
                int next_point = neigh[0];
                if(visit.contains(next_point))continue;
                minHeap.offer(new int[]{next_cost+cost, next_point});
                
            }

        }
        return (visit.size()==n)?res:-1;
    }
}
