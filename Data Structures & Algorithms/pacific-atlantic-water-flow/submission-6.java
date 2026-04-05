class Solution {
    int[][] heights;
    int[][] directions = {{1, 0},{-1, 0},{0, 1},{0, -1}};
    int rows;
    int cols;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        rows = heights.length;
        cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        for (int c = 0; c < cols; c++){
            dfs(0, c, pacific);
            dfs(rows - 1, c, atlantic);
        }
        for (int r = 0; r < rows; r++){
            dfs(r, 0, pacific);
            dfs(r, cols -1 , atlantic);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                if (atlantic[r][c] && pacific[r][c]){
                    res.add(new ArrayList<>(Arrays.asList(r, c)));
                }
            }
        }
        return res;
        
    }
    public void dfs(int r, int c, boolean[][] ocean){
        ocean[r][c] = true;
        for (int[] dir: directions){
            int newR = r + dir[0];
            int newC = c + dir[1];
            if (newR >= 0 && newR < rows && newC >= 0 && newC < cols
                && !ocean[newR][newC] && heights[newR][newC] >= heights[r][c] ){
                    dfs(newR, newC, ocean);
                }
        }

    }
}
