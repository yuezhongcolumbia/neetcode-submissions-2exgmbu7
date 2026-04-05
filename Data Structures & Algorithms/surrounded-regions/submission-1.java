class Solution {
    private int[][] directions = new int[][]{
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };
    int rows;
    int cols;
    public void solve(char[][] board) {
        rows = board.length;
        cols = board[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if ((r == 0 || r == rows - 1 || c == 0 || c == cols - 1) && board[r][c] == 'O'){
                    q.add(new int[]{r, c});
                }
            }
        }
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            board[r][c] = 'Y';
            for(int[] dir: directions){
                int newR = r + dir[0];
                int newC = c + dir[1];
                if (newR >= 0 && newR < rows && newC >= 0 && newC < cols && board[newR][newC] == 'O'){
                    q.add(new int[]{newR, newC});
                }
            }
        }
        for (int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if (board[r][c] == 'Y') {
                    board[r][c] = 'O';
                }
                else if (board[r][c] == 'O'){
                    board[r][c] = 'X';
                }
            }
        }
    }
}
