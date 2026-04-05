class Solution {
    public static class Pair{
        String node;
        double weight;
        public Pair(String node, double weight){
            this.node = node;
            this.weight = weight;
        }

    }
    Map<String, List<Pair>> adj;
    Set<String> visit;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //build adj
        adj = new HashMap<>();
        visit = new HashSet<>();
        for (int i = 0; i < equations.size(); i++){
            List<String> equation = equations.get(i);
            double value = values[i];
            String a = equation.get(0);
            String b = equation.get(1);
            adj.computeIfAbsent(a, k -> new ArrayList<>()).add(new Pair(b, value));
            adj.computeIfAbsent(b, k -> new ArrayList<>()).add(new Pair(a, 1/value));
        }
        //loop query
        double[] res = new double[queries.size()];
        for (int i = 0; i < res.length; i++){
            List<String> query = queries.get(i);
            res[i] = dfs(query.get(0), query.get(1));
            visit.clear();
        }
        return res;
    }
    public double dfs(String node, String target){
        if (!adj.containsKey(node) || !adj.containsKey(target)) return -1.0;
        if (node.equals(target)) return 1.0;
        
        visit.add(node);
        double res = -1.0;
        for (Pair nei: adj.get(node)){
            if (!visit.contains(nei.node)){
                res = dfs(nei.node, target);
                if (res != -1.0){
                    res *= nei.weight;
                    return res;
                }
            }
            
        }
        return res;
    } 
}