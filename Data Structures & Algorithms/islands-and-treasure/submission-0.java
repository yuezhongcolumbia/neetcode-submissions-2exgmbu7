//Multi-source BFS
class Solution {    
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int inf = 2147483647; 
        Queue<int[]>queue = new LinkedList<>();

        for(int r =0; r<rows;r++){
            for(int c = 0; c<cols;c++){
                if (grid[r][c]==0){
                    queue.add(new int[]{r,c});
                }
                
            }
        }

        int[][]directions = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()){
            int[]point = queue.poll();
            int row = point[0];
            int col = point[1];
            for(int[]dir:directions){
                int nr = row+dir[0];
                int nc = col+dir[1];
                if(nr>=0&&nc>=0&&nr<rows&&nc<cols&&grid[nr][nc]==inf){
                    queue.add(new int[]{nr,nc});
                    grid[nr][nc]=grid[row][col]+1; 
                }else{
                    continue;
                }
            }
        }
    }
}
