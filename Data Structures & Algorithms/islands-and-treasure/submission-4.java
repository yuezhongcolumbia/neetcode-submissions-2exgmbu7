class Solution {
    private static final int[][] dirs = { { -1, 0 }, { 0, -1 },
                         { 1, 0 }, { 0, 1 } };
    public void islandsAndTreasure(int[][] grid) {
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
        while (!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            for(int[] dir: dirs){
                int newR = r + dir[0];
                int newC = c + dir[1];
                if (newR >= rows || newC >= cols || newR < 0 ||
                    newC < 0 || grid[newR][newC] != Integer.MAX_VALUE){
                        continue;
                    }
                grid[newR][newC] = grid[r][c] + 1;
                q.add(new int[]{newR, newC});
            }
        }    
    }
}
