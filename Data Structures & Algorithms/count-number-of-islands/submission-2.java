class Solution {
    int res;
    char[][] grid;
    int rows;
    int cols;
    int[][] directions = {{1, 0},{-1, 0},{0, 1},{0, -1}};
    boolean[][] visit;
    public int numIslands(char[][] grid) {
        this.grid = grid;
        res = 0;
        rows = grid.length;
        cols = grid[0].length;
        visit = new boolean[rows][cols];
        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                if (grid[r][c] == '1'){
                    dfs(r, c);
                    res++;
                }
            }
        }
        return res;

    }
    public void dfs(int r, int c){
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == '0' || visit[r][c]){
            return;
        }
        visit[r][c] = true;
        grid[r][c] = '0';
        for (int[] dir: directions){
            dfs(r + dir[0], c + dir[1]);
        }

    }
}
