class Solution {
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        visited = new boolean[rows][cols];
        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                if (backtrack(board, word, r, c, 0)){
                    return true;
                }
            }
        }
        return false;
        
    }
    public boolean backtrack(char[][] board, String word, int r, int c, int i){
        int rows = board.length;
        int cols = board[0].length;
        if (i == word.length()){
            return true;
        }
        if (r < 0 || c < 0 || r >= rows || c >= cols
                || word.charAt(i) != board[r][c] || visited[r][c]){
                    return false;
                }
        
        visited[r][c] = true;
        boolean res = 
            backtrack(board, word, r + 1, c, i + 1)||
            backtrack(board, word, r, c + 1, i + 1)||
            backtrack(board, word, r - 1, c, i + 1)||
            backtrack(board, word, r, c - 1, i + 1);
        visited[r][c] = false;
        return res;
    }
}
