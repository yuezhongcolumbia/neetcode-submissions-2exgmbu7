class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int l = 0, r = rows * cols - 1;
        while (l <= r){
            int m = (l + r) / 2;
            int row = m / cols;
            int col = m % cols;
            if (matrix[row][col] == target){
                return true;
            }
            if (matrix[row][col] > target){
                r = m - 1;
            } else if (matrix[row][col] < target){
                l = m + 1;
            } 
            
        }
        return false;
    }
}
