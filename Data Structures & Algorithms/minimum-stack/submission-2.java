class MinStack {
// obj:
//     1. push -> push
//     2. pop -> LIFO pop
//     3. top -> peek
//     4. getMin() -> retries the minimum
// impl:
//     1. monotonic increasing stack?
//         1. what about push time?
//         2. when you pop? what to do ?
//             just compare and pop from montonic stack if needed
    Stack<Integer> stack;
    Stack<Integer> minStack;
    
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || minStack.peek() >= val){
            minStack.push(val);
        }
    }
    
    public void pop() {
        int poped = stack.pop();
        if (poped == minStack.peek()){
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
