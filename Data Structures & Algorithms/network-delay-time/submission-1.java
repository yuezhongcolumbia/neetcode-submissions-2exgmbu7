class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //adjacent list
        Map<Integer, List<int[]>>adj = new HashMap<>();
        for(int[]uwv:times){
            adj.computeIfAbsent(uwv[0], key->new ArrayList<>()).add(new int[]{uwv[1],uwv[2]});
        }
        //visit
        Set<Integer>visit = new HashSet<>();

        //result
        int time = 0;

        //Min Heap
        PriorityQueue<int[]>minHeap = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));

        minHeap.offer(new int[]{0,k});

        while(!minHeap.isEmpty()){
            int[]curr = minHeap.poll();
            int curr_node = curr[1];
            int curr_time = curr[0];
            if(visit.contains(curr_node)){
                continue;
            }
            visit.add(curr_node);
            time = curr_time;
            if(adj.keySet().contains(curr_node)){
                for(int[]neig : adj.get(curr_node)){
                    int next_node = neig[0];
                    int next_time = curr_time + neig[1];
                    minHeap.offer(new int[]{next_time,next_node});
                }
            }


        }
        System.out.print(visit.size());
        return visit.size()==n?time:-1;
    }
}
//if(!visit.contains(next_node))
