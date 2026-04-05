class Solution {
    Map<Integer, List<Integer>> adj;
    Set<Integer> visit;
    public boolean validTree(int n, int[][] edges) {
        adj = new HashMap<>();
        visit = new HashSet<>();
        for (int i  = 0; i < n; i++){
            adj.put(i, new ArrayList<>());
        }
        for (int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        if(!dfs(0, -1)) return false;
        return visit.size() == n;
    }
    public boolean dfs(int i, int parent){
        if (visit.contains(i)){
            return false;
        }
        visit.add(i);
        for (int nei: adj.get(i)){
            if (nei == parent) continue;
            if (!dfs(nei, i)) return false;
        }
        return true;
    }
}
