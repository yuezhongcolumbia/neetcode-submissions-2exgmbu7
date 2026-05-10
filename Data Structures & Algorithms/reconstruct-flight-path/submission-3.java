class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        for(List<String> ticket: tickets){
            String src = ticket.get(0);
            String dest = ticket.get(1);
            adj.computeIfAbsent(src, k -> new PriorityQueue<>()).add(dest);
        }
        List<String> res = new ArrayList<>();
        dfs(adj, res, "JFK");
        Collections.reverse(res);
        return res;
    }
    public void dfs(Map<String, PriorityQueue<String>> adj, List<String> res, String src){
        
        while(adj.get(src) != null && !adj.get(src).isEmpty()){
            String dest = adj.get(src).poll();
            dfs(adj, res, dest);
        }
        res.add(src);
    }
}
