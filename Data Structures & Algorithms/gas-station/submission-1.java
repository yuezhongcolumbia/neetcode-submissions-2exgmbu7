class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //brute force
        for (int i = 0; i < gas.length; i++){
            int tank = 0;
            tank += gas[i] - cost[i];
            if (tank < 0){
                continue;
            }
            int j = (i + 1) % gas.length;
            while (j != i ){
                tank += gas[j] - cost[j];
                if (tank < 0) {
                    break;
                }
                j = (j + 1) % gas.length;
            }
            if (j == i){
                return i;
            }

        }
        return -1;
    }
}
