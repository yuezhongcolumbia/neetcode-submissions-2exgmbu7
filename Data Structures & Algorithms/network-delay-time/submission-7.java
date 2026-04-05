class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<int[]>minHeap = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        int[]distance = new int[n+1];
        Arrays.fill(distance,200);
        distance[k]=0;
        Map<Integer,List<int[]>>map = new HashMap<>();
        for(int i=0;i<times.length;i++){
            int[]nodes = times[i];
            int src = nodes[0];
            int dest = nodes[1];
            int weight = nodes[2];
            if(src == k){           
                minHeap.add(new int[]{0,k});
            }
            
            minHeap.add(new int[]{200,src});
            map.computeIfAbsent(src, key->new ArrayList<>()).add(new int[]{dest,weight});

        }

        while(!minHeap.isEmpty()){
            
            int[]curr = minHeap.poll();
            int node = curr[1];
            System.out.print(node);
            if(map.get(node)!=null){
            for(int[]neighbor: map.get(node)){
                int dest = neighbor[0];
                int weight = neighbor[1];
                int d = distance[node]+weight;
                if(d>=distance[dest])continue;
                distance[dest]=d;
                minHeap.add(new int[]{d,dest});
            }
        }
        }
        int res = 0;
        for(int i =1; i<=n;i++){
            System.out.print(distance[i]);
            res = Math.max(res,distance[i]);
        }
        return (res!=200)?res:-1;
    }
}
