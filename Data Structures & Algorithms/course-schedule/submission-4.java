class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //build indegree
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < numCourses; i++){
            inDegree.put(i, 0);
            adj.put(i, new ArrayList<>());
        }
        
        for (int[] pre: prerequisites){
            inDegree.put(pre[0], inDegree.get(pre[0]) + 1);
            adj.computeIfAbsent(pre[1], k -> new ArrayList<>()).add(pre[0]);
        }
        //build q, insert all 0 indegree node
        Queue<Integer> q = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry: inDegree.entrySet()){
            if (entry.getValue() == 0){
                q.add(entry.getKey());
            }
        }
        int finish = numCourses;
        while(!q.isEmpty()){
            int zeroInDegree = q.poll();
            finish--;
            for(int neighbor: adj.get(zeroInDegree)){
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0){
                    q.add(neighbor);
                }
            }
        }
        return finish == 0 ? true : false;
    }
}
