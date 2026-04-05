class Solution {
    public String foreignDictionary(String[] words) {
      StringBuilder sb = new StringBuilder();
      Map<Character,List<Character>>graph = new HashMap<>();
      for(String word: words){
        for(char c: word.toCharArray()){
            graph.putIfAbsent(c, new ArrayList<>());
        }
      }
      for(int i =0; i< words.length;i++){
        for(int j = i+1; j<words.length;j++){
            String left = words[i];
            String right = words[j];
            int min_size = Math.min(left.length(), right.length());
            if(left.length()>right.length()&& left.substring(0,right.length()).equals(right)){
                return "";
            }
            for(int m = 0; m<min_size;m++){
                if(left.charAt(m)!=right.charAt(m)){
                    graph.get(left.charAt(m)).add(right.charAt(m));
                    break;
                }
            }
        }
      }
      Queue<Character>queue = new LinkedList<>();
      Map<Character,Integer>inDegree = getInDegree(graph);
      for(Map.Entry<Character,Integer> entry: inDegree.entrySet()){
        if(entry.getValue()==0){
            queue.add(entry.getKey());
            sb.append(entry.getKey());
        }
      }
      
      while(!queue.isEmpty()){
        char c = queue.poll();
        for(char neighbor: graph.get(c)){
            inDegree.put(neighbor,inDegree.get(neighbor)-1);
            if(inDegree.get(neighbor)==0){
                queue.offer(neighbor);
                sb.append(neighbor);
            }
        }
      }
      String res = sb.toString();
      System.out.print(res.length());
      
      return (res.length()!=graph.size())?"":res;
    }
    public static Map<Character,Integer> getInDegree(Map<Character,List<Character>>graph){
        Map<Character,Integer>res = new HashMap<>();
        for(char c: graph.keySet()){
            res.putIfAbsent(c,0);
        }
        graph.entrySet().forEach((entry)->{
            for(char c: entry.getValue()){
                res.put(c,res.get(c)+1);
            }
        }
            
        );
        return res;
    }
}
