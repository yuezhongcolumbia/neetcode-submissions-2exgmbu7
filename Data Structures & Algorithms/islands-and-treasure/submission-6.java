class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int[][] directions = {{1, 0},{-1, 0},{0, 1},{0, -1}};
        Queue<int[]> q = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                if (grid[r][c] == 0){
                    q.add(new int[]{r, c});
                }
            }
        }
        int step = 0;
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                int[] cur = q.poll();
                int curR = cur[0];
                int curC = cur[1];
                
                grid[curR][curC] = Math.min(step, grid[curR][curC]);
                for (int[] dir: directions){
                    int newR = curR + dir[0];
                    int newC = curC + dir[1];
                    if (newR >= 0 && newR < rows && newC >=0 && newC < cols 
                        && grid[newR][newC] == 2147483647){
                            q.add(new int[]{newR, newC});
                        }
                }
               
            }
             step++;
        }
       
    }
}
