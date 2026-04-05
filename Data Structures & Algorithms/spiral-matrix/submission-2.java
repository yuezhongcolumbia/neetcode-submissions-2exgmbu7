class Solution {
    int m;
    int n;
    int[][] matrix;
    List<Integer> res;
    public List<Integer> spiralOrder(int[][] matrix) {
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
       res = new ArrayList<>();
       dfs(0, 1, m, n, 0, -1);
       return res;
    }
    public void dfs(int dr, int dc, int rows, int cols, int r, int c){
        if (cols == 0){
            return;
        }
        
        for(int i = 0; i < cols; i++){
            r += dr;
            c += dc;
            res.add(matrix[r][c]);
        }
        dfs(dc, -dr, cols , rows -1 , r, c);
    }
}
