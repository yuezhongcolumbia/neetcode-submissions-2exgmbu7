class Solution {
    public int openLock(String[] deadends, String target) {
        //two sets
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        begin.add("0000");
        end.add(target);
        //prepare visit
        Set<String> visit = new HashSet<>();
        for (String s: deadends){
            visit.add(s);
        }
        if (visit.contains("0000")) return -1;
        if (visit.contains(target)) return -1;
        visit.add("0000");
        int steps = 0;
        while(!begin.isEmpty() && !end.isEmpty()){
            //if begin is larger swap
            if (begin.size() > end.size()){
                Set<String> temp = begin;
                begin = end;
                end = temp;
            }
            steps++;
            //temp set for eligble neighbors
            Set<String> temp = new HashSet<>();
            for(String s: begin){
                for(int i: new int[]{-1, 1}){
                    //generate neighbors
                    char[] charArr = s.toCharArray();
                    for (int j = 0; j < 4; j++){
                        charArr[j] = (char)((charArr[j] - '0' + i + 10) % 10 + '0');
                        String neighbor = new String(charArr);
                        if (end.contains(neighbor)) return steps;
                        if (!visit.contains(neighbor)){
                            visit.add(neighbor);
                            temp.add(neighbor);
                        }
                        charArr = s.toCharArray();
                    }
                    
                }
            }
            begin = temp;
        }
        return -1;
    }
}