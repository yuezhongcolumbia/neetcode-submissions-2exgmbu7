class Solution {
    int[][] directions = {{1,0},{-1,0},{0,1},{-1, 1},{1, -1},{1, 1},{0, -1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        // 8 directional
        // return the number of zeros.

        // visit? just make the cell one
        // choice: boundry check + grid[][] == 0;
        int rows = grid.length;
        int cols = grid[0].length;
        if (grid[0][0] == 1 || grid[rows - 1][cols - 1] == 1) return -1;
        int steps = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];
                if (r == rows - 1 && c == cols - 1) return steps;
                for (int[] dir: directions){
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 0){
                        grid[nr][nc] = 1;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
            steps++;
        }
        return -1;


    }
}