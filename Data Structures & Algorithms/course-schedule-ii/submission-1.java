class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //indegree + adj
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < numCourses; i++){
            inDegree.put(i, 0);
            adj.put(i, new ArrayList<>());
        }
        for (int[] pre: prerequisites){
            inDegree.put(pre[0], inDegree.get(pre[0]) + 1);
            adj.get(pre[1]).add(pre[0]);
        }
        //q, insert all 0 indegree
        Queue<Integer> q = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry: inDegree.entrySet()){
            if (entry.getValue() == 0){
                q.add(entry.getKey());
            }
        }

        //res
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            Integer node = q.poll();
            res.add(node);
            for(Integer nei: adj.get(node)){
                inDegree.put(nei, inDegree.get(nei) - 1);
                if (inDegree.get(nei) == 0){
                    q.add(nei);
                }
            }
        }
        if (res.size() < numCourses) return new int[0];
        int[] order = new int[numCourses];
        for (int i = 0; i < numCourses; i++){
            order[i] = res.get(i);
        }
        return order;
        
        
    }
}
