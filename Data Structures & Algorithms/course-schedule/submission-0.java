class Solution {
    private Set<Integer>visit = new HashSet<>();
    private  Map<Integer, List<Integer>>map = new HashMap<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        for(int i =0; i < numCourses; i++){
            map.put(i,new ArrayList<>());
        }
        for(int[]pre:prerequisites){
            map.get(pre[0]).add(pre[1]);
        }
        for(int i = 0; i < numCourses; i ++){
            if(!dfs(i))return false;
        }
        return true;
    }
    private boolean dfs(int i ){
        if(visit.contains(i)){
            return false;
        }
        if(map.get(i).isEmpty()){
            return true;
        }
        visit.add(i);
        for(int pre: map.get(i)){
            if(!dfs(pre)){
                return false;
            }
        }
        visit.remove(i);
        map.put(i,new ArrayList<>());
        return true;
    }
}
