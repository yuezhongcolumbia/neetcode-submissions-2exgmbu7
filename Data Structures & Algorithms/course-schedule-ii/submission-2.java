class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++){
            adj.put(i, new ArrayList<>());
        }
        for (int[] pre: prerequisites){
            adj.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;
        }
        List<Integer> resList = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++){
            if (inDegree[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            resList.add(cur);
            for (int nei: adj.get(cur)){
                inDegree[nei] --;
                if (inDegree[nei] == 0){
                    q.add(nei);
                }
            }
        }
        if (resList.size() != numCourses) return new int[]{};
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++){
            res[i] = resList.get(i);
        }
        return res;


    }
}
