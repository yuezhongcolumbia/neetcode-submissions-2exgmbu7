class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        //if n == 1, return 1
        int n = position.length;
        if (n == 1) return 1;
        //int[][] pos_speed
        int[][] posSpeed = new int[n][2];
        for (int i = 0; i < n; i++){
            posSpeed[i] = new int[]{position[i], speed[i]};
        }
        //sort
        Arrays.sort(posSpeed, (a, b)  -> Integer.compare(b[0], a[0]));
        //stack.push第一个
        Stack<int[]> stack = new Stack<>();
        stack.push(posSpeed[0]);
        //

        for (int i = 1; i < n; i++){
            double curTime = (double)(target - posSpeed[i][0]) / posSpeed[i][1];
            double preTime = (double)(target - stack.peek()[0]) / stack.peek()[1];
            if (curTime <= preTime) continue;
            stack.push(posSpeed[i]);
        }
        return stack.size();
    }
}
