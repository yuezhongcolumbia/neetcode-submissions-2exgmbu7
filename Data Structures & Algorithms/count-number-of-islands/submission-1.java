class Solution {
    boolean[][] visited;
    char[][] grid;
    int rows;
    int cols;
    private static final int[][] directions = {{1, 0},{-1, 0},{0, 1},{0, -1}};
    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        this.grid = grid;
        visited = new boolean[rows][cols];
        int res = 0;
        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                if (grid[r][c] == '1' && !visited[r][c]){
                    dfs(r,c);
                    res++;
                }
            }
        }
        return res;
    }
    public void dfs(int r, int c){
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == '0' || visited[r][c]){
            return;
        }
        visited[r][c] = true;
        for (int[] dir: directions){
            dfs(r + dir[0], c + dir[1]);
        }
    }
}
