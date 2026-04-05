class Solution {
    public int minimumEffortPath(int[][] heights) {
        //pq,effort,4 directions
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0] - b[0]);
        int[][] efforts = new int[rows][cols];
        for(int[] effort: efforts){
            Arrays.fill(effort, Integer.MAX_VALUE);
        }
        
        pq.add(new int[]{0, 0, 0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int effort = cur[0];
            int r = cur[1];
            int c = cur[2];
            if (efforts[r][c] < effort) continue;
            if (r == rows - 1 && c == cols - 1) return effort;
            for (int[] dir: directions){
                int newR = r + dir[0];
                int newC = c + dir[1];
                if (newR < 0 || newR >= rows || newC < 0 || newC >= cols) continue;
                int newEffort = Math.max(effort, Math.abs(heights[r][c] - heights[newR][newC]));
                if (newEffort < efforts[newR][newC]) {
                     efforts[newR][newC] = newEffort;
                     pq.add(new int[]{newEffort, newR, newC});
                }
               
            }
        }
        return 0;

    }
}