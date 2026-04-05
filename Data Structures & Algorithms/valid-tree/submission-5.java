class Solution {
    Map<Integer, List<Integer>> adj;
    boolean[] visit;
    int count;

    public boolean validTree(int n, int[][] edges) {
        // 1. connected use count
        // 2. cycle? use visit
        adj = new HashMap<>();
        visit = new boolean[n];
        count = 0;
        for (int i = 0; i < n; i++){
            adj.put(i, new ArrayList<>());
        }
        for(int[] edge: edges){
            int a = edge[0];
            int b = edge[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        if (!dfs(0, -1)){
            return false;
        }
        return count == n;

    }
    public boolean dfs(int i, int parent){
        if (visit[i]) {
            return false;
        }
        visit[i] = true;
        count++;
        for (int nei: adj.get(i)){
            if (nei == parent) continue;
            if (!dfs(nei, i)){
                return false;
            }
        }
        return true;
    }
}
