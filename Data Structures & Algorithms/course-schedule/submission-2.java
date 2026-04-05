class Solution {
    Set<Integer> visit;
    Map<Integer, List<Integer>> adj;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //visit set
        visit = new HashSet<>();
        //adjacent map
        adj = new HashMap<>();
        for (int[] pre: prerequisites){
            int crs = pre[0];
            int preCrs = pre[1];
            adj.computeIfAbsent(crs, k -> new ArrayList<>()).add(preCrs);
        }
        for(int i = 0; i < numCourses; i++){
            if (!dfs(i))return false;
        }
        return true;
    }
    public boolean dfs(int crs){
        if (!adj.containsKey(crs)) return true;
        if (visit.contains(crs)) return false;
        visit.add(crs);
        for(int neighbor: adj.get(crs)){
            if (!dfs(neighbor))return false;
        }
        visit.remove(crs);
        adj.remove(crs);
        return true;
    }
}
