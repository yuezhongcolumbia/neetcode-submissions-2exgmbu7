class Solution {
    public int orangesRotting(int[][] grid) {
       Queue<int[]> q = new LinkedList<>();
       int rows = grid.length;
       int cols = grid[0].length;
       int[][] directions = {{1, 0},{-1, 0},{0, 1},{0, -1}};
       int fresh = 0;
       for(int r = 0; r <  rows; r++){
        for(int c = 0;  c< cols; c++){
            if (grid[r][c] == 2){
                q.add(new int[]{r, c});
            } else if(grid[r][c] == 1){
                fresh++;
            }
        }
       }
       int time = 0;
       while(!q.isEmpty() && fresh >0){
            int size = q.size();
            for (int i = 0; i < size; i++){
                int[] cur = q.poll();
                int curR = cur[0];
                int curC = cur[1];
                for (int[] dir: directions){
                    int newR = curR + dir[0];
                    int newC = curC + dir[1];
                    if (newR >= 0 && newR < rows && newC >=0 && newC < cols 
                        && grid[newR][newC] == 1){
                            q.add(new int[]{newR, newC});
                            grid[newR][newC] = 2;
                            fresh--;
                        }
                }
            }
            time++;
       }
       return fresh == 0 ? time : -1;
    }
}
