class FreqStack {
    int maxFreq;
    Map<Integer, Stack<Integer>> stackMap;
    Map<Integer, Integer> freqMap;
    public FreqStack() {
        maxFreq = 0;
        stackMap = new HashMap<>();
        freqMap = new HashMap<>();
    }
    
    public void push(int val) {
        //update freqMap
        freqMap.put(val, freqMap.getOrDefault(val, 0) +1);
        //update maxFreq if there is one, and new freq, stack pair for stackMap
        int curCnt = freqMap.get(val);
        if (curCnt > maxFreq){
            maxFreq = curCnt;
            stackMap.put(maxFreq, new Stack<>());
        }
        //update stackMap
        stackMap.get(curCnt).push(val);
    }
    
    public int pop() { 
        //pop from stackMap
        int res = stackMap.get(maxFreq).pop();
        //update freqMap
        freqMap.put(res, freqMap.get(res) - 1);
        //if  freq, stack is empty, update maxFreq, delete from stackMap
        if (stackMap.get(maxFreq).isEmpty()){
            stackMap.remove(maxFreq);
            maxFreq --;
            
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