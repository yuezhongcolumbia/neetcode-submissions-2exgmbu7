class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[]count = new int[26];
        for(char c:tasks){
            count[c-'A' ]++;
        }

        PriorityQueue<Integer>maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]>queue = new LinkedList<>();

        for(int freq: count){
            if(freq>0){
             maxHeap.offer(freq);   
            }
            
        }
        int time = 0;
        while(!maxHeap.isEmpty()|| !queue.isEmpty()){
            if(!queue.isEmpty() && queue.peek()[1]== time){
                   maxHeap.offer(queue.peek()[0]);
                   queue.poll(); 
            }
            if(!maxHeap.isEmpty()){
                int curr_task = maxHeap.poll()-1;
                if(curr_task> 0){
                    queue.offer(new int[]{curr_task, time + n+1});
                }
                
            }
            

            time++;


        }
        return time;

    }
}
