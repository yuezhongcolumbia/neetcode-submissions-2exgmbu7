class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String>visited = new HashSet<>();
        for(String s : deadends){
            visited.add(s);
        }
        int step = 0;
        Queue<String>queue = new LinkedList<>();
        queue.add("0000");
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i =0; i < size; i ++){
                String curr = queue.poll();
                if(curr.equals(target)){
                    return step;
                }
                if(visited.contains(curr)){
                    continue;
                }
                visited.add(curr);
                for(String next_state: nextState(curr)){
                    if(!visited.contains(next_state)){
                    queue.offer(next_state);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private List<String> nextState(String curr){
        List<String>result = new ArrayList<>();
        char[] arr = curr.toCharArray();
        for(int i =0; i <4; i++){
            char c = arr[i];
            
            arr[i]= (c=='9')?'0':(char)(c+1);
            result.add(new String(arr));
           
            arr[i]=(c=='0')?'9':(char)(c-1);
            result.add(new String(arr));

            arr[i]= c;
            
        }
        return result;


    } 
}