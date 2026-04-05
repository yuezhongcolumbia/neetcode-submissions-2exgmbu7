class Solution {
    private Map<Integer,List<Integer>>adj = new HashMap<>();
    private Set<Integer>cycle = new HashSet<>();
    private Set<Integer>visit = new HashSet<>();
    private List<Integer>list = new ArrayList<>();
        
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        for(int[]pre:prerequisites){
            adj.computeIfAbsent(pre[0],k->new ArrayList<>()).add(pre[1]);
        }
        
        for(int c = 0; c<numCourses; c++){
            if(!dfs(c)){
                return new int[0];
            }
        }
        int[]res = new int[numCourses];
        for(int i =0 ; i<numCourses; i ++){
            res[i]= list.get(i);
        }
        return res;


    }

    private boolean dfs(int c){
        if(cycle.contains(c)){
            return false;
        }
        if(visit.contains(c)){
            return true;
        }
        cycle.add(c);

        for(int pre: adj.getOrDefault(c, new ArrayList<>())){
            if(!dfs(pre)){
                return false;
            }
        }
        cycle.remove(c);
        list.add(c);
        visit.add(c);

        



        return true;
    }
}
