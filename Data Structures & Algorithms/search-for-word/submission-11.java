class Solution {
    int rows;
    int cols;
    char[][] board;
    String word;
    boolean[][] visit;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        rows = board.length;
        cols = board[0].length;
        visit = new boolean[rows][cols];
        for (int r = 0 ; r < rows; r++){
            for (int c = 0; c < cols; c++){
                if (backtrack(r, c, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean backtrack(int r, int c, int n){
        if (n == word.length()){
            return true;
        }
        if (r >= rows || r < 0 || c >= cols || c < 0 || board[r][c] != word.charAt(n) || visit[r][c]){
            return false;
        }
        visit[r][c] = true;
        boolean res = 
            backtrack(r + 1, c, n + 1) 
        ||backtrack(r, c + 1, n + 1) 
        ||backtrack(r - 1, c, n + 1) 
        ||backtrack(r, c - 1, n + 1);

        visit[r][c] = false;
        return res;

    }
}
