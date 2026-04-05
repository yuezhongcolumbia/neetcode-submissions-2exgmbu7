class Solution {
    private static <T> boolean topoSort(int numCourses, Map<T, List<T>>graph){
        Queue<T>queue = new LinkedList<>();
        List<T>res = new ArrayList<>();
        Map<T, Integer>indegree= getIndegree(graph);
        for(T node: indegree.keySet() ){
            if(indegree.get(node)==0){
                queue.offer(node);
            }
        }
        while(!queue.isEmpty()){
            T node = queue.poll();
            res.add(node);
            for(T neighbor: graph.get(node)){
                indegree.put(neighbor,indegree.get(neighbor)-1);
                if(indegree.get(neighbor)==0){
                    queue.offer(neighbor);
                }
            }
        }
        return res.size()==numCourses;
    }

    private static <T> Map<T, Integer>getIndegree(Map<T, List<T>>graph){
        Map<T, Integer> inDegree = new HashMap<>();
        for(T node: graph.keySet()){
            inDegree.put(node,0);
        }
        graph.keySet().forEach((node)->{
            for(T neighbor: graph.get(node)){
                inDegree.put(neighbor, inDegree.get(neighbor)+1);
            }
        });
        return inDegree;

    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>>graph = new HashMap<>();
        for(int i =0; i<numCourses; i++){
            graph.put(i, new ArrayList<>());
        }
        for(int[]pre:prerequisites){
            int node = pre[1];
            graph.get(node).add(pre[0]);
            
        }
        return topoSort(numCourses, graph);
    }
}
