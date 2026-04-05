class Solution {
    Map<Integer, List<Integer>> adj;
    Set<Integer> visit;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adj = new HashMap<>();
        for (int i = 0; i < numCourses; i++){
            adj.put(i, new ArrayList<>());
        }
        for (int[] pre: prerequisites){
            adj.get(pre[0]).add(pre[1]);
        }
        visit = new HashSet<>();
        for (int i = 0; i < numCourses; i++){
            if (!dfs(i))return false;
        }
        return true;
    }
    public boolean dfs(int course){
        if (visit.contains(course)){
            return false;
        }
        if (adj.get(course).isEmpty()){
            return true;
        }
        visit.add(course);
        for (int nei: adj.get(course)){
            if (!dfs(nei)) return false;
        }
        adj.put(course, new ArrayList<>());
        visit.remove(course);
        return true;
    }
}
