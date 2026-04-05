class Solution {
    private int[][]directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public boolean exist(char[][] board, String word) {
        boolean[][]visited= new boolean[board.length][board[0].length];
        for(int i =0; i<board.length;i++){
            for(int j =0; j<board[0].length; j++){
                if(dfs(visited,board,word,0,i,j)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(boolean[][]visited,char[][]board, String word, int index, int r, int c){
        if(board[r][c]!=word.charAt(index)){
            return false;
        }
        if(index == word.length()-1){
            return true;
        }
        visited[r][c] = true;
        
        for(int[]dir:directions){
            int nr = r + dir[0];
            int nc = c + dir[1];
            
            if(nr>=0 && nr<board.length && nc>=0 && nc < board[0].length && !visited[nr][nc]){
                    
                if( dfs(visited,board, word, index+1, nr, nc)){
                    return true;
                }            }
                
            
            
        }
        visited[r][c]=false;
        return false;

    }
}
