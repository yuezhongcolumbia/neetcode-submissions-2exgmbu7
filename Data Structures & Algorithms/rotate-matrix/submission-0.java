class Solution {
    public void rotate(int[][] matrix) {
        reverse(matrix);
        int n = matrix.length;
        for (int r = 0; r < n; r++){
            for (int c = r; c < n; c++){
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
        }
    }
    public void reverse(int[][] matrix){
        int n = matrix.length;
        for (int i  = 0; i < matrix.length / 2; i++){
            int[] temp = matrix[i];
            matrix[i] = matrix[n - 1 - i];
            matrix[n - 1 - i] = temp;
        }
    }
}
