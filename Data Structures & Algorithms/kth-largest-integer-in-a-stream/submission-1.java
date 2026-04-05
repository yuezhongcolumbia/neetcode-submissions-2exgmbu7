class KthLargest {
    private int k;
    private Queue<Integer> queue;
    public KthLargest(int k, int[] nums) {
        this.queue = new PriorityQueue<>();
        for(int i: nums){
            queue.offer(i);
        }
        while(queue.size()>k){
            queue.poll();
        }
        this.k = k;
    }
    
    public int add(int val) {
        queue.offer(val);
        if(queue.size()>k){queue.poll();}
        
        return queue.peek();

    }
}
