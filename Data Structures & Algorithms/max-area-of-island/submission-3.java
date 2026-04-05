class Solution {
    private static final int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    int[][] grid;
    int rows;
    int cols;
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                if (grid[r][c] == 1){
                    res = Math.max(res, dfs(r, c));
                }
            }
        }
        return res;   
    }
    public int dfs(int r, int c){
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == 0)return 0;
        int res = 1;
        grid[r][c] = 0;
        for (int[] dir: directions){
            res += dfs(r + dir[0], c + dir[1]);
        }
        return res;
        
    }
    
    
}
