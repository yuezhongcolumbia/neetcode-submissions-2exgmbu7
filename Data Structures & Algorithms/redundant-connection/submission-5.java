class Solution {
    Map<Integer, List<Integer>> adj;
    Set<Integer> visit;
    Set<Integer> cycle;
    int cycleStart;
    public int[] findRedundantConnection(int[][] edges) {
        adj = new HashMap<>();
        cycle = new HashSet<>();
        visit = new HashSet<>();
        int n = edges.length;
        for(int i = 1; i <= n; i++){
            adj.put(i, new ArrayList<>());
        }
        for(int[] edge: edges){
            int a = edge[0];
            int b = edge[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        cycleStart = -1;
        
        dfs(1, -1);
        for (int i = n - 1; i >=0; i--){
           int a = edges[i][0];
            int b = edges[i][1];
            if (cycle.contains(a) && cycle.contains(b)){
                return new int[]{a, b};
            }
        }
        return new int[0];
    }
    public boolean dfs(int node, int parent){
        if (visit.contains(node)){
            cycleStart = node;
            return true;
        }
        visit.add(node);
        for(int nei: adj.get(node)){
            if (nei == parent)continue;
            if (dfs(nei, node)){
                if (cycleStart != -1){
                    cycle.add(node);
                }
                
                if (cycleStart == node){
                    cycleStart = -1;
                }
                return true;
            }
        }
        return false;
    }
}
