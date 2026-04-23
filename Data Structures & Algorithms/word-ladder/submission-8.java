class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 1. all lower case
        // 2. choices:
        //     in the wordList, we should turn it into wordSet for faster lookup. remove word from 
        //     set if we jump to the word.
        // 3. geiNeighbor:
        //     string -> charArr
        //     for (len of the word){
        //         for (26 char){
        //             replace
        //             add to res
        //         }
        //     }
        //     O(L), L is the longest word length;
        // Time complexity O (NL), L is the longest word length, N is the length of wordList
        Set<String> wordSet = new HashSet<>();
        for (String s: wordList){
            if (s.equals(beginWord)) continue;
            wordSet.add(s);
        }
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int steps = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                String cur = q.poll();
                if (cur.equals(endWord)) return steps;
                for (String nei: getNeighbor(cur)){
                    if (wordSet.contains(nei)){
                        wordSet.remove(nei);
                        q.offer(nei);
                    }
                }
            }
            steps++;
        }
        return 0;

    }
    public List<String> getNeighbor(String s){
        char[] charArr = s.toCharArray();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++){
            char original = charArr[i];
            for (char c = 'a'; c <= 'z'; c++){
                charArr[i] = c;
                res.add(new String(charArr));
            }
            charArr[i] = original;
        }
        return res;
    }
}
