class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length-1;
        int cols = board[0].length - 1;
        Set<String>path = new HashSet<>();
        for(int r = 0 ; r<= rows; r ++){
            for(int c = 0; c<=cols;c++){
                if(backtrack(r,c,board,word,0,path)){
                    return true;

                }
            }
        }
        return false;
    }
    public boolean backtrack(int r, int c, char[][]board, String word, int i, Set<String>path ){
        int rows = board.length-1;
        int cols = board[0].length - 1;
        if(i == word.length()){
            return true;
        }
        if(r<0 || c<0 || r > rows || c>cols||path.contains(r+","+c)||board[r][c]!=word.charAt(i)){
            return false;
        }

        path.add(r+","+c);
        boolean res= 
        backtrack(r,c-1,board,word,i+1,path)||
        backtrack(r,c+1,board,word,i+1,path)||
        backtrack(r-1,c,board,word,i+1,path)||
        backtrack(r+1,c,board,word,i+1,path);
        path.remove(r+","+c);

        return res;
    }
}

