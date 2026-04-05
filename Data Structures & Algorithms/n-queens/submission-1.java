class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][]board = new char[n][n];
        List<List<String>>res_list = new ArrayList<>();
        for(int i =0; i <n; i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        backtrack(board,0,res_list);
        return res_list;
        

    }
    public void backtrack(char[][]board, int index, List<List<String>>res_list){
        //leaf logic
        int n = board.length;
        if(index==n){
            List<String>sol = new ArrayList<>();
            for(char[]row:board){
                String row_str = new String(row);
                sol.add(row_str);
            }
            res_list.add(sol);
            return;
        }
        //edge logic
        for(int c = 0; c< n; c++){
            if(isValid(board, index, c)){
                board[index][c]= 'Q';
                backtrack(board,index+1,res_list);
                board[index][c]='.';
            }
        }
        return;

    }
    //constraint
    public boolean isValid(char[][]board,int row,int col){
        int n = board.length;
        //horizontal check
        for(int i=0; i<n;i++){
            if(board[row][i]=='Q'){
                return false;
            }
        }
        //vertical check
        for(int i =0; i <n; i++){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        //positive diagonal check
        for(int i =1; (row-i)>=0 && (col+i)<n;i++){
            if(board[row-i][col+i]=='Q'){
                return false;
            }
        }
        //negative diagonal check
        for(int i =1; (row-i)>=0 && (col-i)>=0;i++){
            if(board[row-i][col-i]=='Q'){
                return false;
            }
        }
        return true;
    }
}
