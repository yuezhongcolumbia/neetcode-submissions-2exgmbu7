class Solution {
    List<List<String>> tickets;
    Map<String, List<String>> adj;
    List<String> path;
    int used;
    public List<String> findItinerary(List<List<String>> tickets) {
        // 1. depart from jfk
        // 2. smallest lexi order:
        //     sort based on destination
        // 3. use all the ticket:
        //     once the adj map is empty
        // 4. every ticket should only be used once: 
        //     delete the edge once used, delete the node once all edge are gone
        // 5. backtrack + early stop
        // 6.time complexity:
        //     every route possible, n!?
        this.tickets = tickets;
        path = new ArrayList<>();
        adj = new HashMap<>();
        used = 0;
        tickets.sort((a,b) -> a.get(1).compareTo(b.get(1)));
        for(List<String> ticket: tickets){
            String depart = ticket.get(0);
            String dest = ticket.get(1);
            adj.computeIfAbsent(depart, k -> new ArrayList<>()).add(dest);
        }
        path.add("JFK");
        backtrack("JFK");
        return path;

    }
    public boolean backtrack(String stop){
        if (used == tickets.size()){
            return true;
        }
        if (!adj.containsKey(stop)) return false;
        for(int i = 0; i < adj.get(stop).size(); i++){
            String next = adj.get(stop).get(i);
            path.add(next);
            used++;
            adj.get(stop).remove(i);
            if (backtrack(next)) return true;
            path.remove(path.size() - 1);
            used--;
            adj.get(stop).add(i, next);
        }
        return false;
    }
}