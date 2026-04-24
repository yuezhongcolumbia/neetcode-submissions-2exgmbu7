class Solution {
    int[][] directions = {{-2, -1},{-2,1},{2,1},{2,-1},{1,-2},{-1,-2},{1,2},{-1,2}};
    public int minKnightMoves(int x, int y) {
        // 1. problem:
        //     start at 0,0
        //     move 2 in cardinal, 1 in orthogonal
        //     return minimum steps to reach x,y

        // visit boolean 2d array

        // 8 directions

        // steps for result

        // choices: not visited
        boolean[][] visit = new boolean[1000][1000];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visit[302][302] = true;
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];
                if (r == x && c == y) return steps;
                for (int[] dir: directions){
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (!visit[nr + 302][nc + 302]){
                        visit[nr + 302][nc + 302] = true;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
