class FreqStack {
    HashMap<Integer, Integer> freq;
    int max;
    HashMap<Integer,Stack<Integer>> stackMap;

    public FreqStack() {
        //initilize
        //map freq;
        freq = new HashMap<>();
        //int max;
        max = 0;
        //map<Integer, Stack> stackMap;
        stackMap = new HashMap<>();
    }
    
    public void push(int val) {
        //update freq;
        freq.put(val, freq.getOrDefault(val, 0) + 1);
        //update max;
        max = Math.max(max, freq.get(val));
        //update stackMap, push into stack;
        stackMap.computeIfAbsent(freq.get(val), k -> new Stack<>()).add(val);
    }
    
    public int pop() {
        //search key==max in stackMap;
        //pop it, make it res;
        int res = stackMap.get(max).pop();
        System.out.print(res);
        //update freq;
        freq.put(res, freq.get(res) - 1);
        // if (that stack is empty){
        //     update max;
        // }
        if (stackMap.get(max).isEmpty()){
            max--;
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