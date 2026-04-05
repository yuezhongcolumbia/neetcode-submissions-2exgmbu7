class Solution {
    private int[][]directions = {{1,0},{-1,0},{0,1},{0,-1}};
    private int rows; 
    private int cols ;  
    
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        rows = grid.length;
        cols = grid[0].length;
        Queue<int[]>queue = new LinkedList<>();
        int time = 0;
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                
                    if(grid[r][c]==2){
                        queue.add(new int[]{r,c});
                    }
                    if(grid[r][c]==1){
                        fresh++;
                    }
            }
            }
       
        //
        while(!queue.isEmpty()&&fresh>0){
            int size = queue.size();
          
            for(int i = 0; i<size;i++){
            int[]rot = queue.poll();
            for(int[]dir:directions){
                int nr=rot[0]+dir[0];
                int nc = rot[1]+dir[1];
                if(nr>=0&&nc>=0&&nr<rows&&nc<cols&&grid[nr][nc]==1){
                    
                    queue.add(new int[]{nr,nc});
                    grid[nr][nc]=2;
                    fresh--;
                }
                
            }
            
            }
            time++;
        }
     
        return fresh==0?time:-1; 
    }
}
