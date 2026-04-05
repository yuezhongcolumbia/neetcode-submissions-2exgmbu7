class Solution {
    private static int[][]directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int res = 0;
        int[] curr = new int[1];
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c]==1){
                    curr[0]=1;
                    bfs(grid,r,c,curr);
                    res = Math.max(res,curr[0]);

                }
            }
        }
        return res;
    }

    private void bfs(int[][]grid,int r,int c, int[]curr){
        Queue<int[]>queue = new LinkedList<>();
        queue.add(new int[]{r,c});
        grid[r][c]=0;
        while(!queue.isEmpty()){
            int[]point = queue.poll();
            int row = point[0];
            int col = point[1];
            for(int[]dir:directions){
                int nr = row+dir[0];
                int nc = col+dir[1];
                if(nr>=0&&nc>=0&&nr<grid.length&&nc<grid[0].length&&grid[nr][nc]==1){
                    queue.add(new int[]{nr,nc});
                    grid[nr][nc]=0;
                    curr[0]++;
                }
            }
        }


    }
}
