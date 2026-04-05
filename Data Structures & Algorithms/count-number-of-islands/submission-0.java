class Solution {
    private static List<int[]>directions = Arrays.asList(new int[]{1, 0},   // down
        new int[]{-1, 0},  // up
        new int[]{0, -1},  // left
        new int[]{0, 1} );
   
   
    public int numIslands(char[][] grid) {
        int res = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for(int r=0;r<rows;r++){
            for(int c = 0; c<cols; c++){
                if(grid[r][c]=='1'){
                    bfs(grid,r,c);
                    res++;
                }
            }
        }
        return res;
        


    }
    private void bfs(char[][]grid,int r, int c){
        Queue<int[]>queue = new LinkedList<>();
        queue.add(new int[]{r,c});
        grid[r][c]='0';
        while(!queue.isEmpty()){
            int[]point = queue.poll();
            int row = point[0];
            int col = point[1];
            for(int[]dir:directions){
                int new_row = row+dir[0];
                int new_col = col+dir[1];
                if(new_row>=0&&new_col>=0&&new_row<grid.length&&new_col<grid[0].length&&
                grid[new_row][new_col]=='1'){
                    queue.add(new int[]{new_row,new_col});
                    grid[new_row][new_col]='0';
                }


            }
        }
    }
}
