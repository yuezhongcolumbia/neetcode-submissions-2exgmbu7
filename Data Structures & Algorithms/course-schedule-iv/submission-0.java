class Solution {
    Map<Integer, List<Integer>> adj;
    Map<Integer, int[]> memo;
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        //build adj, inst memo
        adj = new HashMap<>();
        memo = new HashMap<>();
        for (int i = 0; i < numCourses; i++){
            adj.put(i, new ArrayList<>());
            int[] empty = new int[numCourses];
            Arrays.fill(empty, -1);
            memo.put(i, empty);
        }
        for (int[] pre: prerequisites){
            adj.get(pre[1]).add(pre[0]);
            memo.get(pre[1])[pre[0]] = 1;
        }
        List<Boolean> res = new ArrayList<>();
        for(int[] query: queries){
            res.add(dfs(query[1], query[0]));
        }
        return res;
    }
    public boolean dfs(int crs, int pre){
        if (memo.get(crs)[pre] != -1){  
            return  memo.get(crs)[pre] == 1 ? true : false;
        }
        for (int nei: adj.get(crs)){
            if (dfs(nei, pre)){
                memo.get(crs)[pre] = 1;
                 return true;
            }
        }
        memo.get(crs)[pre] = 0;
        return false;
    }
}