class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Map<String, List<String>>map = new HashMap<>();
        map.put(beginWord, findNeighbor(beginWord,wordList));
        for(int i =0; i<wordList.size();i++){
            map.put(wordList.get(i),findNeighbor(wordList.get(i),wordList));
        }
        Set<String>visited= new HashSet<>();
        int step = 1;
        
        Queue<String>queue = new LinkedList<>();
        queue.add(beginWord);
        while(!queue.isEmpty()){
            int size = queue.size();
            System.out.print(size);
            for(int i =0; i<size;i++){
                String polled = queue.poll();
                if(polled.equals(endWord)){
                    return step;
                }
                for(String neighbor: map.get(polled)){
                    if(visited.contains(neighbor)){
                        continue;
                    }
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
            step++;
        }
        return 0;
    }
    public static List<String> findNeighbor(String s, List<String>list){
        int diffNum = 0;
        List<String>res = new ArrayList<>();
        for(int i =0; i<list.size();i++){
            for(int j = 0; j<s.length();j++){
                if(s.charAt(j)!=list.get(i).charAt(j)){
                    diffNum++;
                }
                if(diffNum>1){
                    break;
                }
            }
            if(diffNum==1){
                res.add(list.get(i));
            }
            diffNum=0;
        }
        return res;
    }
}
