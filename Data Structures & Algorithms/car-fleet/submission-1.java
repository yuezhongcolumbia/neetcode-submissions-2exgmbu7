class Solution {
    // obj:
    //     1. car can only catch up:
    //         they drive at same speed
    //     2. count how many group of cars ended up in different position when the first group reach target
    // impl:
    //     1. simulation?, the time is when the first car arrive target
    //     2. we want to know when time is up, how many different position
    //     3. how to satisfy the "catch up" mechanism?
    public int carFleet(int target, int[] position, int[] speed) {
        //making pairs
        int n = position.length;
        int[][] pairs = new int[n][n];
        for (int i = 0; i <  position.length; i++){
            pairs[i] = new int[]{position[i], speed[i]};
        }

        //sort pairs
        Arrays.sort(pairs, (a,b) -> Integer.compare(b[0] , a[0]));
        Stack<Double> stack = new Stack<>();
        for(int[] pair: pairs){
            //calculate time
            double time = (double)(target - pair[0])/ pair[1];
            if (!stack.isEmpty() && time <= stack.peek()){
                continue;
            } else {
                stack.push(time);
            }
        }
        return stack.size();
    }
}
