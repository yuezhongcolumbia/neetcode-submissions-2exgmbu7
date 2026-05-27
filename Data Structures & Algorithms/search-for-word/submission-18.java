class Solution {
    char[][] board;
    String word;
    StringBuilder path;
    int rows;
    int cols;
    int[][] directions = {{1, 0},{-1, 0},{0, -1},{0, 1}};
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        path = new StringBuilder();
        rows = board.length;
        cols = board[0].length;
        
        // loop every grid, find the first character that matches
        for (int r = 0;  r < rows; r++){
            for (int c = 0;  c < cols; c++){
                if (board[r][c] == word.charAt(0)){
                    boolean[][] used = new boolean[rows][cols];
                    used[r][c] = true;
                    path.append(board[r][c]);
                    if (backtrack(r, c, 0, used)) return true;
                    path.deleteCharAt(0);
                }
            }
        }
        return false;
        // backtrack, choices are 4 directions, boundary check, no used, and char match at idx, word.length >= 1
        // if path.length is word length, return true

    }
    public boolean backtrack(int r, int c, int idx, boolean[][] used){
        if (path.length() == word.length()) return true;
        for (int[] dir: directions){
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && !used[nr][nc] && board[nr][nc] == word.charAt(idx + 1)){
                path.append(board[nr][nc]);
                used[nr][nc] = true;
                if (backtrack(nr, nc, idx + 1, used)) return true;
                path.deleteCharAt(path.length() - 1);
                used[nr][nc] = false;
            }
        }
        return false;
        
    }
}
