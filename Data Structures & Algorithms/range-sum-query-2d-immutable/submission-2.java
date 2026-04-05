class NumMatrix {
    int[][] prefixMat;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        prefixMat = new int[m + 1][n + 1];
        for (int r = 0; r < m; r++){
            int prefix = 0;
            for (int c = 0; c < n; c ++){
                prefix += matrix[r][c];
                int above = prefixMat[r][c + 1];
                prefixMat[r + 1][c + 1] = prefix + above;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++;
        col1++;
        row2++;
        col2++;
        int bottomRight = prefixMat[row2][col2];
        int left = prefixMat[row2][col1 - 1];
        int above = prefixMat[row1 - 1][col2];
        int doubleCount = prefixMat[row1 - 1][col1 - 1];
        return bottomRight - left - above + doubleCount;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */