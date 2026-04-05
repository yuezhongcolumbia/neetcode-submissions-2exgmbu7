class MinStack {
    private Deque<Integer>stack;
    private Deque<Integer>minStack;
    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
        
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty()){
            minStack.push(val);
        }else{
            int prev_min = minStack.peek();
            if(val<=prev_min){
                minStack.push(val);
            }else{
                minStack.push(prev_min);
            }

        }

    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
        
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
