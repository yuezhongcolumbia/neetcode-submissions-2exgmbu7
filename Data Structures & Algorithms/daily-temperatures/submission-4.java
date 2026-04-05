class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> monoDec = new Stack<>();
        int n = temperatures.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++ ){
            while (!monoDec.isEmpty() && temperatures[i] > temperatures[monoDec.peek()]){
                int idx = monoDec.pop();
                res[idx] = i - idx;
            }
            monoDec.push(i);
        }
        return res;
    }
}
