class Solution {
    int[][] grid;
    int rows;
    int cols;
    boolean[][] visited;
    public int islandPerimeter(int[][] grid) {
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];
        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                if (grid[r][c] == 1){
                    return dfs(r, c);
                }
            }
        }
        return 0;
        
    }
    public int dfs(int r, int c){
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == 0){
            return 1;
        }
        if (visited[r][c]){
            return 0;
        }
        visited[r][c] = true;
        int up =  dfs(r - 1, c) ;
        int down =  dfs(r + 1, c);
        int left = dfs(r , c - 1) ;
        int right = dfs(r , c + 1) ;

        return up + down + left + right;

    }
}