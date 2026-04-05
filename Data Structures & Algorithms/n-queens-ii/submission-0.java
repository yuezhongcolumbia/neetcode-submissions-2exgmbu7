class Solution {
    private int res;
    public int totalNQueens(int n) {
        res = 0;
        char[][]board = new char[n][n];
        for(int i =0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]=',';
            }
        }
        backtrack(board,0);
        return res;
    }
    public void backtrack(char[][]board, int r){
        //leaf logic
        if(r==board.length){
            res++;
            return;
        }

        //edge logic
        for(int c =0; c<board.length ;c++){
            //constraint
            if(isValid(board,r,c)){
                board[r][c] = 'Q';
                backtrack(board,r+1);
                board[r][c] =',';
            }


        }


    }

    private static boolean isValid(char[][]board, int r, int c){
        int n = board.length;
        for(int i = r; i>=0;i--){
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