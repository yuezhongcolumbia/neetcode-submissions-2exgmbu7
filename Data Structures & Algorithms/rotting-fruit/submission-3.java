class Solution {
    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int rows;
    int cols;
    public int orangesRotting(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                if (grid[r][c] == 2){
                    q.add(new int[]{r, c});
                }
                if (grid[r][c] == 1){
                    fresh++;
                }
            }
        }
        int steps = 0;
        while (!q.isEmpty() && fresh > 0){
            int size = q.size();
            for (int i = 0; i < size; i++){
                int[] rotten = q.poll();
                for (int[] dir: directions){
                    int newR = rotten[0] + dir[0];
                    int newC = rotten[1] + dir[1];
                    if (newR >= 0 && newR < rows && newC >= 0 && newC < cols && grid[newR][newC] == 1){
                        grid[newR][newC] = 2;
                        fresh--;
                        q.add(new int[]{newR, newC});
                    }
                }
            }
            steps++;
        }
        return fresh == 0 ?steps:-1;
    }
}
