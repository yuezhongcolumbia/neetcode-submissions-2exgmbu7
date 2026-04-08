class KthLargest {
    int size ;
    PriorityQueue<Integer> minHeap;
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        size = k;
        for (int num: nums){
            minHeap.offer(num);
            if (minHeap.size() > k){
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > size){
            minHeap.poll();
        }
        
        return minHeap.peek();
    }
}
