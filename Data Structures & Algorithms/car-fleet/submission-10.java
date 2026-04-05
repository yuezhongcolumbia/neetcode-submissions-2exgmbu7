class Solution {
    public static class Pair{
        int position;
        double time;
        public Pair(int position, double time){
            this.position = position;
            this.time = time;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Pair> stack = new Stack<>();
        int n = position.length;
        Pair[] posTime = new Pair[n];
        for(int i = 0; i < n; i ++){
            double time = (double)(target- position[i]) / speed[i];
            posTime[i] = new Pair(position[i], time);
        }
        Arrays.sort(posTime, (a, b) -> Integer.compare(b.position, a.position));
        for (Pair pair: posTime){
            if (stack.isEmpty() || pair.time > stack.peek().time){
                stack.push(pair); 
            } 
            
        }
        return stack.size();
    }
}
