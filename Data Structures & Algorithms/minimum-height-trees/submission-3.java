class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1)return Arrays.asList(0);
        //build adj and indegree;
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++){
            indegree.put(i, 0);
            adj.put(i, new ArrayList<>());
        }
        for (int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            indegree.put(u, indegree.get(u) + 1);
            indegree.put(v, indegree.get(v) + 1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++){
            if (indegree.get(i) == 1){
                q.offer(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()){
            res = new ArrayList<>();
            int size = q.size();
            for(int i = 0; i < size; i++){
                int cur = q.poll();
                res.add(cur);
                for (int nei: adj.get(cur)){
                    indegree.put(nei, indegree.get(nei) - 1);
                    if (indegree.get(nei) == 1){
                        q.offer(nei);
                    }
                }
            }
        }
        return res;
     }
}