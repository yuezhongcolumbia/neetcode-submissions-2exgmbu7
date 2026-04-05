class StockSpanner {
    // obj:
    //     find the span of the stock, meaning how many days in the past can we find a day where stock price is
    //     stricly higher than today
    // impl:
    //     mono decreasing stack
    //     state: monostack, Pair<price, span>
    //static class pair
    private static class Pair {
        int price;
        int span;
        public Pair (int price, int span){
            this.price = price;
            this.span = span;
        }
    }
    private Stack<Pair> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && price >= stack.peek().price){
            Pair prevPair = stack.pop();
            span += prevPair.span;
        }
        stack.push(new Pair(price,span));
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */