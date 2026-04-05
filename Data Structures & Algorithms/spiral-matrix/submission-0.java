class Solution {
    List<Integer> res;
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        res = new ArrayList<>();
        dfs(matrix, m, n, 0, -1, 0, 1);
        return res;

    }
    public void dfs(int[][] matrix, int row, int col, int r, int c, int dr, int dc){
        if (row == 0 || col == 0) return;

        for (int i = 0; i < col; i++){
            r += dr;
            c += dc;
            res.add(matrix[r][c]);
        }
        dfs(matrix, col, row - 1, r, c, dc, -dr);


    }
}