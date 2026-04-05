class Solution {
   //bidirectional bfs

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = beginWord.length();
        //wordList -> wordSet, take beginWord off wordSet
        Set<String> wordSet = new HashSet<>();
        for (String s: wordList){
            if (s.equals(beginWord)) continue;
            wordSet.add(s);
        }
        //if end not in wordSet return
        if (!wordSet.contains(endWord)) return 0;
        //build 2qs   
        Queue<String> begin = new LinkedList<>();
        Queue<String> end = new LinkedList<>();
        Map<String, Integer> beginMap = new HashMap<>();
        Map<String, Integer> endMap = new HashMap<>();
        begin.add(beginWord);
        end.add(endWord);
        beginMap.put(beginWord, 1);
        endMap.put(endWord, 0);
        while(!begin.isEmpty() && !end.isEmpty()){
            // swap if first q is larger
            if (begin.size() > end.size()){
                Queue<String> temp = begin;
                begin = end;
                end = temp;
                Map<String, Integer> tempMap = beginMap;
                beginMap = endMap;
                endMap = tempMap;
            }
            int size = begin.size();
            for(int i = 0; i < size; i++){
                String cur = begin.poll();
                int step  = beginMap.get(cur);
                for(int j = 0; j < len; j ++){
                    for(char c = 'a'; c <= 'z'; c++){
                        char[] charArr = cur.toCharArray();
                        charArr[j] = c;
                        String newStr = new String(charArr);
                        if (endMap.containsKey(newStr)) return step + 1 + endMap.get(newStr);
                        if (wordSet.contains(newStr)){
                            // put in begin q
                            begin.offer(newStr);
                            wordSet.remove(newStr);
                            beginMap.put(newStr, step + 1);
                        }
                    }
                }
            }
        }
        return 0;

    }
}
