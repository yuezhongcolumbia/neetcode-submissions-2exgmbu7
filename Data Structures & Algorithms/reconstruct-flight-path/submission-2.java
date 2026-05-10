class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> adj = new HashMap<>();
        for(List<String> ticket: tickets){
            adj.putIfAbsent(ticket.get(0), new ArrayList<>());
        }
        tickets.sort((a,b) -> a.get(1).compareTo(b.get(1)));
        for(List<String> ticket: tickets){
            adj.get(ticket.get(0)).add(ticket.get(1));
        }
        List<String> res = new ArrayList<>();
        res.add("JFK");
        dfs(adj, res, "JFK", tickets.size() + 1);
        return res;



    }
    public boolean dfs(Map<String, List<String>> adj, List<String> res, String src, int targetLen){
        if (targetLen == res.size()) return true;

        if (!adj.containsKey(src)){
            return false;
        }
        
        // for(String next: adj.get(src)){
        //     res.add(next);
        //     if(dfs(adj, res, next, targetLen)) return true;
            
        // }
        List<String> dest = adj.get(src);
        for(int i = 0; i < dest.size(); i++){
            String next = dest.get(i);
            res.add(next);
            adj.get(src).remove(i);
            if(dfs(adj, res, next, targetLen)) return true;
            res.remove(res.size() - 1);
            adj.get(src).add(i, next);
        }
        return false;
}
}
