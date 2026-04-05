class Solution {
    char[][] board;
    String word;
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    boolean[][] visit;
    public boolean exist(char[][] board, String word) {
        // choices: 4 direction, and board[r][c] == word.charAt(i) and you cant go back,
        // end: i == word.length;
        this.board = board;
        this.word = word;
        int m = board.length;
        int n = board[0].length;
        visit = new boolean[m][n];
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if (backtrack(r, c, 0)){
                    return true;
                }
                
            }
        }
        return false;
    }
    public boolean backtrack(int r, int c, int i){
        if (board[r][c] != word.charAt(i)) return false;
        if (i == word.length() - 1){
            return true;
        }
       
        visit[r][c] = true;
        for (int[] dir: directions){
            int newR = r + dir[0];
            int newC = c + dir[1];
            if (newR >= 0 && newR < board.length
                          && newC >=0 && newC < board[0].length
                          && !visit[newR][newC]){
                if (backtrack(newR, newC, i + 1)){
                    return true;
                }
                
            }
        }
        visit[r][c] = false;
        
        return false;
    }
}
