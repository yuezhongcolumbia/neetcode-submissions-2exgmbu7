class Solution {
    Map<Integer, List<Integer>> adj;
    Set<Integer> visit;
    public int countComponents(int n, int[][] edges) {
        //build adj
        adj = new HashMap<>();
        visit = new HashSet<>();
        int res = 0;
        for (int i = 0; i < n; i++){
            adj.put(i, new ArrayList<>());
        }
        for (int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        //traverse
        for (int i = 0; i < n; i++){
            if (!visit.contains(i)){
                dfs(i);
                res++;
            }
        }
        return res;

    }
    public void dfs(int n){
        if (visit.contains(n)) return;
        visit.add(n);
        for (int nei: adj.get(n)){
            dfs(nei);
        } 
    }
}
