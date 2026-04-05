class Solution {
    int rows;
    int cols;
    int[][] directions = {{1, 0},{-1, 0},{0, 1},{0, -1}};
    public void solve(char[][] board) {
        rows = board.length;
        cols = board[0].length;
        for (int r = 0; r < rows; r++){
            dfs(board, r, 0);
            dfs(board, r, cols - 1);
        }
        for (int c = 0; c < cols; c++){
            dfs(board, 0, c);
            dfs(board, rows - 1, c);
        }
        for (int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if (board[r][c] == 'O'){
                    board[r][c] = 'X';
                } else if (board[r][c] == 'T'){
                    board[r][c] = 'O';
                }
            }
        }
    }
    public void dfs(char[][] board, int r, int c){
        if (r < 0 || r >= rows || c < 0 || c >= cols || board[r][c] != 'O'){
            return;
        }
        board[r][c] = 'T';
        for (int[] dir: directions){
            int newR = r + dir[0];
            int newC = c + dir[1];
            dfs(board, newR, newC);
        }

    }
}
