class Solution {
    List<List<Integer>> adj;
    int n;
    int destination;
    int[] states;
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        // 1. cycle: visit
        // 2. directed: can be cached

        adj = new ArrayList<>();
        this.n= n;
        for (int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for (int[] edge: edges){
            int a = edge[0];
            int b = edge[1];
            adj.get(a).add(b);
        }
        this.destination = destination;
        states = new int[n];
        return dfs(source);
    }
    public boolean dfs(int node){
        if (states[node] == 1) return false; // cycle
        if (states[node] == 2) return true; //proven true
        if (adj.get(node).size() == 0){
            return node == destination;
        }
        if (node == destination) return false;
        states[node] = 1;
        for (int next: adj.get(node)){
            if (!dfs(next)) return false;
        }
        states[node] = 2;
        return true;
    }
}
