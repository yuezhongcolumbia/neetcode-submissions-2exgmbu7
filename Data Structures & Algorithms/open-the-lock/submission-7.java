class Solution {
    public int openLock(String[] deadends, String target) {
        // need a visit
        // choice:
        //     1. not deadends
        //     2. not visited
        //     3. neighbors:
        //         1. turn into char array
        //         2. if +: special case is 9, convert back to String add to res
        //         3. if - : special cases is 0,  convert back to String add to res
        Set<String> visit = new HashSet<>();
        visit.add("0000");
        for (String str: deadends){
            visit.add(str);
            if (str.equals("0000")) return -1;
        }
        Queue<String> q = new LinkedList<>();
        q.add("0000");
        int steps = 0;
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                String cur = q.poll();
                if (cur.equals(target)) return steps;
                for (String nei: getNeighbor(cur)){
                    if (!visit.contains(nei)){
                        q.add(nei);
                        visit.add(nei);
                    }
                }
            }
            steps++;
        }
        return -1;
        
                

    }
    public List<String> getNeighbor(String s){
        char[] charArr = s.toCharArray();
        List<String> res = new ArrayList<>();
        // for (char c: charArr){
        //     char original = c;
        //     c = c == '9' ? '0' : (char)(c - '0' + 1); 
        //     res.add(charArr.toString());

        //     c = c == '0' ? '9' : (char)(c - '0' - 1);
        //     res.add(charArr.toString());
        //     c = original;
        // }
        for (int i = 0; i < 4; i++){
            char original = charArr[i];
            charArr[i] = original == '9' ? '0' : (char)(original - '0' + 1 + '0');
            res.add(new String(charArr));

            charArr[i] = original == '0' ? '9' : (char)(original - '0' - 1 + '0');
            res.add(new String(charArr));
            charArr[i] = original;
        }
        return res;
    }
}