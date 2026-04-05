class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        //edge case,n=0;
        if(n==0){
            return new ArrayList<>();
        }
        if(n==1){
            return new ArrayList<>(Arrays.asList(0));
        }
        
        //populate adj list
        Map<Integer,List<Integer>>adj = new HashMap<>();
        for(int[]edge:edges){
            int vert_1 = edge[0];
            int vert_2 = edge[1];
            adj.computeIfAbsent(vert_1, key1->new ArrayList<>()).add(vert_2);
            adj.computeIfAbsent(vert_2, key2->new ArrayList<>()).add(vert_1);
        }
         //construct degree list
         int[]degree = new int[n];
         for(int vert: adj.keySet()){
            int size = adj.get(vert).size();
            degree[vert] = size;
         }
        //add initial leaf node to the queue
        Queue<Integer>queue = new LinkedList<>();
        for(int i =0; i<degree.length; i++){
            if(degree[i]==1){
                queue.offer(i);
            }
        }

        List<Integer>res = new ArrayList<>();
        //while loop
            while(!queue.isEmpty()){
                //clear previous leaf node in res list
                res.clear();
                //poll the node(traversing current level of leaf node)
                int curr_size = queue.size();
                for(int i =0; i<curr_size;i++){
                    //add it to the res list
                    int leaf = queue.poll();
                    res.add(leaf);
                    //traverse through the leaf node neighbor
                    for(int neighbor:adj.get(leaf)){
                        //update neighbor degree
                        degree[neighbor]--;
                        //if neighbor become leaf add it to the queue
                        if(degree[neighbor]==1){
                            queue.offer(neighbor);
                        }
                    }
                }
            }
            return res;
    }
}