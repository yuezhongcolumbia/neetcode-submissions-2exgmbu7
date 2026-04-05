class Solution {
    Map<Integer, List<Integer>> adj;
    Set<Integer> visit;
    Set<Integer> cycle;
    int cycleStart;
    public int[] findRedundantConnection(int[][] edges) {
        //build adj
        adj = new HashMap<>();
        visit = new HashSet<>();
        cycle = new HashSet<>();
        for (int[] edge: edges){
            adj.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);

        }
        cycleStart = -1;
        dfs(1, -1);
        for (int i = edges.length - 1; i >=0 ; i--){
            int u = edges[i][0];
            int v = edges[i][1];
            if (cycle.contains(u) && cycle.contains(v)){
                return edges[i];
            }
        }
        return new int[0];
    }
    public boolean dfs(int node, int par){
        if (visit.contains(node)){
            // cycle start update;
            cycleStart = node;
            return true;
        }
        visit.add(node);
        for(int nei: adj.get(node)){
            if (nei == par) continue;
            //found cycle
            if (dfs(nei, node)){
                if (cycleStart != -1){
                    // add in cycle;
                    cycle.add(node);
                }
                if (node == cycleStart){
                    //update cyclestart, preventing adding nodes up the recursion stack
                    cycleStart = -1;
                }
                return true;
            }
        }
        return false;
    }
}
