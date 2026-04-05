class Solution {
    int res;
    int [][] grid;
    int rows;
    int cols;
    int[][] directions = {{1, 0},{-1, 0},{0, 1},{0, -1}};
    boolean[][] visit;
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        res = 0;
        rows = grid.length;
        cols = grid[0].length;
        visit = new boolean[rows][cols];
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
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == 0 || visit[r][c]){
            return 0;
        }
        visit[r][c] = true;
        grid[r][c] = 0;
        int area = 1;
        for (int[] dir: directions){
            area += dfs(r + dir[0], c + dir[1]);
        }
        return area;
    }
}
