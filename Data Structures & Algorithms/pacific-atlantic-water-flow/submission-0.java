class Solution {
    private int[][]directions ={{1,0},{-1,0},{0,-1},{0,1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][]pacific = new boolean[rows][cols];
        boolean[][]atlantic = new boolean[rows][cols];

        for(int c = 0;c<cols;c++){
            dfs(0,c,heights ,pacific);
            dfs(rows-1,c,heights,atlantic);
        }
        for(int r = 0; r<rows; r++){
            dfs(r,0,heights, pacific);
            dfs(r,cols-1,heights,atlantic);
        }
        List<List<Integer>>res = new ArrayList<>();
        for(int r = 0; r<rows;r++){
            for(int c =0; c<cols; c++){
                if(pacific[r][c]&&atlantic[r][c]){
                    res.add(Arrays.asList(r,c));
                }

            }
        }
        return res;

    }

    private void dfs(int r, int c , int[][]heights, boolean[][]ocean){
        ocean[r][c]= true;
        for(int[]dir:directions){
            int nr = r+dir[0];
            int nc = c+dir[1];
            if(nr>=0&&nr<heights.length && nc>=0 && nc< heights[0].length
            &&!ocean[nr][nc]&& heights[nr][nc]>=heights[r][c]){
                dfs(nr,nc,heights,ocean);
            }
        }



    }
}
