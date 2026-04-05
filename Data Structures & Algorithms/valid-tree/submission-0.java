class Solution {
    Map<Integer, List<Integer>> adj;
    Set<Integer> visit;
    public boolean validTree(int n, int[][] edges) {
        //build adj
        adj = new HashMap<>();
        visit = new HashSet<>();
        for (int i  = 0; i < n; i++){
            adj.put(i, new ArrayList<>());
        }
        for (int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        if (!dfs(0, -1)) return false;
        return visit.size() == n;

    }
    public boolean dfs(int node, int parent){
        if (visit.contains(node)) return false;
        visit.add(node);
        for(int neighbor: adj.get(node)){
            if (neighbor == parent) continue;
            if (!dfs(neighbor, node)) return false;
        }
        return true;
    }
}
