class Solution {
    public int orangesRotting(int[][] grid) {
        // return the time when there is 0 fresh fruit, or -1 if impossible

        //     spread as further as possible but fresh fruit remains -> return -1
        //         1. use freshfruit count , if in the end count>0 return -1
            
        //     bfs:
        //         1. level traversal
        //         2. 4 directions , spread only to fresh, put back to queue
        
        Queue<int[]> q = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        int fresh = 0;
        int[][] directions = {{1,0},{-1,0},{0,-1},{0,1}};
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (grid[i][j] == 2){
                    q.add(new int[]{i, j});
                } else if (grid[i][j] == 1){
                    fresh++;
                }
            }

        }
        int step = 0;
        while (!q.isEmpty() && fresh > 0){
            int size = q.size();
            for (int i = 0; i < size; i++){
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];
                for (int[] dir: directions){
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (nr >=0 && nr < rows && nc >=0 && nc < cols && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        fresh--;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
            step++;
        }
            
        return fresh > 0 ? -1 : step;

    }
}
