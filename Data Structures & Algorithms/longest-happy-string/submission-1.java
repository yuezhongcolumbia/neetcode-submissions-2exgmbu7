class Solution {
    static class Pair{
        int num;
        char c;
        public Pair(int num, char c){
            this.num = num;
            this.c = c;
        }
    }
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair>maxHeap = new PriorityQueue<>((pair_a,pair_b)->pair_b.num-pair_a.num);
        if(a>0)maxHeap.offer(new Pair(a,'a'));
        if(b>0)maxHeap.offer(new Pair(b,'b'));
        if(c>0)maxHeap.offer(new Pair(c,'c'));
        StringBuilder res = new StringBuilder();
        Map<Character,Integer>freq = new HashMap<>();
        freq.put('a',0);
        freq.put('b',0);
        freq.put('c',0);
        while(!maxHeap.isEmpty()){
            Pair curr = maxHeap.poll();
            char curr_char = curr.c;
            int curr_num = curr.num;
            if(freq.get(curr_char)==2){
                if(maxHeap.isEmpty()){
                    break;
                }else{
                    Pair curr_next = maxHeap.poll();
                    char curr_next_char = curr_next.c;
                    int curr_next_num = curr_next.num;
                    freq.put(curr_char,0);
                    freq.put(curr_next_char,1);
                    res.append(curr_next_char);
                    maxHeap.offer(curr);
                    if(curr_next_num-1 <= 0){
                        continue;
                    }else{
                         maxHeap.offer(new Pair(curr_next_num-1,curr_next_char));
                    }
                   
                }

            }else{
                freq.put(curr_char,freq.get(curr_char)+1);
                if(res.length()>=1&& res.charAt(res.length()-1)!=curr_char){
                    char last = res.charAt(res.length()-1);
                    freq.put(last,0);
                }
                res.append(curr_char);
                if(curr_num-1<=0){
                    continue;
                }else{
                     maxHeap.offer(new Pair(curr_num-1,curr_char));
                }
               
            }
            
        }
        return res.toString();
        
    }
}