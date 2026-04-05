class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //edge case
        Set<String> dic = new HashSet<>(wordList);
        if (beginWord.equals(endWord) || !dic.contains(endWord)){
            return 0;
        }
        //prepare two qs, two hashmaps
        
        Queue<String> qBegin = new LinkedList<>();
        Queue<String> qEnd = new LinkedList<>();
        Map<String, Integer> mapBegin = new HashMap<>();
        Map<String, Integer> mapEnd = new HashMap<>();
        qBegin.offer(beginWord);
        qEnd.offer(endWord);
        mapBegin.put(beginWord, 1);
        mapEnd.put(endWord, 1);
        while(!qBegin.isEmpty() && !qEnd.isEmpty()){
            if (qBegin.size() > qEnd.size()){
                Queue<String> qTemp = qBegin;
                qBegin = qEnd;
                qEnd = qTemp;

                Map<String, Integer> mapTemp = new HashMap<>();
                mapTemp = mapBegin;
                mapBegin = mapEnd;
                mapEnd = mapTemp;
            }
            
            for (int i = 0; i < qBegin.size(); i++){
                //get steps
                String curr = qBegin.poll();
                int steps = mapBegin.get(curr);
                for(int j = 0; j < curr.length(); j++){
                    for(char c = 'a'; c <= 'z'; c++){
                        //reconstruct nei;
                        String nei = curr.substring(0, j) + c + curr.substring(j + 1);
                        //validity check and return, which one is first?
                        //filter words not in wordList
                        if (!dic.contains(nei)) continue;
                        //return first
                        if (mapEnd.containsKey(nei)){
                            return steps + mapEnd.get(nei);
                        }
                        //if it hasnt appear in qe and qb, update qb
                        if (!mapBegin.containsKey(nei)){
                            qBegin.add(nei);
                            mapBegin.put(nei, steps + 1);
                        }

                    }
                }
            }
        }
        return 0;

    }
}
