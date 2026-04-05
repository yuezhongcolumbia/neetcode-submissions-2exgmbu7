class FreqStack {
    HashMap<Integer, Integer> freq;
    List<Stack<Integer>> stackList;
    public FreqStack() {
        freq = new HashMap<>();
        stackList = new ArrayList<>();
        stackList.add(new Stack<>());
    }
    
    public void push(int val) { 
        //update freq;
        freq.put(val, freq.getOrDefault(val, 0) + 1);
        int curFreq = freq.get(val);
        // if (curFreq is one index larger than stackList largest index){
        //     add one more stack
        // }
        if (curFreq > stackList.size() - 1){
            stackList.add(new Stack<>());
        }
        // add to corresponding stack
        stackList.get(curFreq).push(val);
    }
    
    public int pop() {
        // pop from the end of the stackList
        int size = stackList.size();
        int res = stackList.get(size - 1).pop();
        // update freq
        freq.put(res, freq.get(res) - 1);
        // if (the last stack of stackList is empty){
        //     remove it
        // }
        if (stackList.get(size - 1).isEmpty()){
            stackList.remove(size - 1);
        }
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */