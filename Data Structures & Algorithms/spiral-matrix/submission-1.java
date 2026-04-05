class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // directions:
        int[][] directions = {{0, 1},{1, 0},{0, -1},{-1, 0}};
        int m = matrix.length;
        int n = matrix[0].length;
        int[] steps = {n, m - 1};
        int r = 0, c = -1, d = 0;
        List<Integer> res = new ArrayList<>();
        while(steps[d % 2] > 0){
            for (int i = 0; i < steps[d % 2]; i++){
                // update r, c 
                r += directions[d][0];
                c += directions[d][1];
                res.add(matrix[r][c]);
            }
            // update steps
            steps[d % 2]--;
            // update directional index
            d = (d + 1) % 4;
        }
        return res;
    }
}
