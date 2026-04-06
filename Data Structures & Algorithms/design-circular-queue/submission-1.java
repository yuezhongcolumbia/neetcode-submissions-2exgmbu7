class MyCircularQueue {
    static class ListNode{
        int val;
        ListNode next;

        public ListNode (int val){
            this.val = val;
            next = null;
        }
    }
    int capacity;
    int size;
    ListNode front;
    ListNode rear;

    public MyCircularQueue(int k) {
        capacity = k;
        front = new ListNode(0);
        rear = front;
        size = k;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false;
        ListNode cur = new ListNode(value);
        rear.next = cur;
        rear = cur;
        capacity--;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;
        front.next = front.next.next;
        if (front.next == null){
            rear = front; 
        }
        capacity++;
        return true;
    }
    
    public int Front() {
        // if (!isEmpty()){
        //     return front.next.val;
        // } else {
        //     return -1;
        // }
        return isEmpty() ? -1 : front.next.val;
    }
    
    public int Rear() {
        return isEmpty() ? -1 : rear.val;
    }
    
    public boolean isEmpty() {
        return capacity == size ? true : false;
    }
    
    public boolean isFull() {
        return capacity == 0 ? true : false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */