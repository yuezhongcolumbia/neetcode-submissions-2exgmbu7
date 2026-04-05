class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Map<Integer, Set<Integer>> allPre = new HashMap<>();
        for (int i = 0; i < numCourses; i++){
            inDegree.put(i, 0);
            adj.put(i, new ArrayList<>());
            allPre.put(i, new HashSet<>());
        }
        for (int[] pre: prerequisites){
            inDegree.put(pre[1], inDegree.get(pre[1]) + 1);
            adj.get(pre[0]).add(pre[1]);
            allPre.get(pre[1]).add(pre[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++){
            if (inDegree.get(i) == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            for (int nei: adj.get(cur)){
                inDegree.put(nei, inDegree.get(nei) - 1);
                if (inDegree.get(nei) == 0){
                    allPre.get(nei).add(cur);
                    allPre.get(nei).addAll(allPre.get(cur));
                    q.add(nei);
                }
            }
        }
        List<Boolean> res = new ArrayList<>();
        for (int[] query: queries){
            if (allPre.get(query[1]).contains(query[0])){
                res.add(true);
            }else{
                res.add(false);
            }
        }
        return res;
    }
}