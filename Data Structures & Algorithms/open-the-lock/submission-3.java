class Solution {
    public int openLock(String[] deadends, String target) {
        
        Queue<String> q = new LinkedList<>();
        q.add("0000");
        Set<String> visited = new HashSet<>();
        for (String s: deadends){
            visited.add(s);
        }
        if (visited.contains("0000")) return -1;
        visited.add("0000");
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
              String cur = q.poll();
              if (cur.equals(target)) return steps;
              List<String> neighbors = neighbors(cur);
              for(String nei: neighbors){
                  if (!visited.contains(nei)){
                    q.add(nei);
                    visited.add(nei);
                  }
                }  
            }
            steps++;
            
        }
        return -1;
    }
    public List<String> neighbors(String s){
        List<String> res = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            char[] arr = s.toCharArray();
            arr[i] = (char)((arr[i] - '0' - 1 + 10) % 10 + '0');
            res.add(new String(arr));
            arr = s.toCharArray();
            arr[i] = (char)((arr[i] - '0' + 1) % 10 + '0');
            res.add(new String(arr));
        }
        return res;
    }
}