class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>>res = new ArrayList<>();
        char[][]board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        backtrack(n,0,board,res);
        return res;
    }

    private static void backtrack(int n, int row, char[][]board, List<List<String>>res){
        if(row==n){
            List<String>board_copy = new ArrayList<>();
            for(char[]r: board){
                String row_copy = new String(r);
                board_copy.add(row_copy);
            }
            res.add(board_copy);
            return;
        }
        for(int col = 0; col<n;col++){
            if(isValid(n,row,col,board)){
                board[row][col]='Q';
                backtrack(n, row+1,  board, res);
                board[row][col]='.';
            }
        }

    }


    private static boolean isValid(int n, int r, int c, char[][]board){
        for(int i = r-1; i>=0; i--){
            if(board[i][c]=='Q'){
                return false;
            }
        }

        for(int i = r-1,  j = c-1; i>=0&&j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        for(int i = r-1,  j = c+1; i>=0&&j<n;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
}
