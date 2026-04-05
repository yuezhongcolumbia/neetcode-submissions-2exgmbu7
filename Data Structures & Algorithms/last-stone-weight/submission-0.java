class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer>queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone:stones){
            queue.offer(stone);
        }
        while(!queue.isEmpty()){
            
            if(queue.size()==1){
                return queue.poll();
            }
            int a = queue.poll();
            int b = queue.poll();
            if(a==b){
                continue;
            }else{
                queue.offer(a-b);
            }

            
        }
        return 0;
    }
}
