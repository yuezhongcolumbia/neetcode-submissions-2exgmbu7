class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        
        Map<Integer,List<Integer>>row_graph = new HashMap<>();
        Map<Integer,List<Integer>>col_graph = new HashMap<>();
        for(int i =1; i<=k;i++){
            row_graph.put(i,new ArrayList<>());
            col_graph.put(i,new ArrayList<>());
        }
        for(int i = 0 ; i < rowConditions.length; i++){
            int[]condition = rowConditions[i];
            row_graph.get(condition[0]).add(condition[1]);
        }
        for(int i = 0 ; i < colConditions.length; i++){
            int[]condition = colConditions[i];
            col_graph.get(condition[0]).add(condition[1]);
        }
        List<Integer>row_order = topoSort(row_graph);
        List<Integer>col_order = topoSort(col_graph);
        if(row_order==null || col_order == null){
            return new int[0][0];
        }
        int[][]matrix = new int[k][k];
        for(int i =1; i<=k;i++){
            int row_index = row_order.indexOf(i);
            int col_index = col_order.indexOf(i);
            matrix[row_index][col_index] = i;
        }
        return matrix;
    }
    public static List<Integer> topoSort(Map<Integer,List<Integer>>graph){
        Map<Integer, Integer>inDegree = getInDegree(graph);
        List<Integer>res = new ArrayList<>();
        Queue<Integer>queue = new LinkedList<>();
        for(int node: graph.keySet()){
            if(inDegree.get(node)==0){
                queue.offer(node);
            }
        }
        while(!queue.isEmpty()){
            int node = queue.poll();
            res.add(node);
            for(int neighbor: graph.get(node)){
                inDegree.put(neighbor,inDegree.get(neighbor)-1);
                if(inDegree.get(neighbor)==0){
                    queue.offer(neighbor);
                }
            }
        }
        return (graph.size()==res.size())?res:null;
    }
    public static Map<Integer,Integer> getInDegree(Map<Integer,List<Integer>>graph){
        Map<Integer,Integer>inDegree = new HashMap<>();
        for(int i =1; i<=graph.size();i++){
            inDegree.put(i,0);
        }
        graph.keySet().forEach((node)->{
            for(Integer neighbor: graph.get(node)){
                inDegree.put(neighbor, inDegree.get(neighbor)+1);
            }

        });
        return inDegree;
    }
}