class Solution {
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public void islandsAndTreasure(int[][] grid) {
        // modify in place
        // fill each cell with distance to nearest treasure chest
        // 0 is treasure, inf is land
        // 4 directions

        // multi directional bfs

        // choices: only inf, bound check
        // how to record steps? record steps + 1, steps start with 0
        Queue<int[]> q = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        for (int r = 0; r < rows ; r++){
            for (int c = 0; c < cols; c++){
                if (grid[r][c] == 0){
                    q.offer(new int[]{r, c});
                }
            }
        }
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];
                for(int[] dir: directions){
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (nr >= 0 && nr < rows && nc >=0 && nc < cols && grid[nr][nc] == 2147483647){
                        grid[nr][nc] = steps + 1;
                        q.offer(new int[]{nr, nc});
                    }                
            }
        }
        steps++;
    }

}
}
