class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>>adj = new HashMap<>();
        tickets.sort((a, b) -> a.get(1).compareTo(b.get(1)));

        for(List<String>ticket:tickets){
            adj.computeIfAbsent(ticket.get(0),k->new ArrayList<>()).add(ticket.get(1));
        }
        List<String>res = new ArrayList<>();
        res.add("JFK");
        if(dfs(adj,res,1,"JFK",tickets.size()+1)){
            return res;
        }else{
            return new ArrayList<>();
        }

    }


    private boolean dfs(Map<String,List<String>>adj, List<String>res, int res_len, String airport, int target_len ){
        if(res_len == target_len){
            return true;
        }
        if(!adj.keySet().contains(airport)){
            return false;
        }
        if(adj.get(airport).isEmpty()&&res_len<target_len){
            return false;
        }
        for(int i =0; i < adj.get(airport).size();i++){
            String dest = adj.get(airport).get(i);
            adj.get(airport).remove(dest);
            res.add(dest);
            if(dfs(adj,res,res_len+1,dest,target_len)){
                return true;

            }else{
                adj.get(airport).add(i,dest);
                res.remove(res.size()-1);
            }

        }
        return false;
    }
}
