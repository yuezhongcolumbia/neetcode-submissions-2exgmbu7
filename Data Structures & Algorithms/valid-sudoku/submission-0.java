class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        Set<Character>[]row = new HashSet[n];
        Set<Character>[]col = new HashSet[n];
        Set<Character>[]box = new HashSet[n];
        for(int i =0; i<n;i++){
            row[i]=new HashSet<Character>();
            col[i]=new HashSet<Character>();
            box[i]=new HashSet<Character>();
        }
        
        for(int r = 0; r<n; r++){
           for(int c = 0; c<n; c++){
                char val = board[r][c];
                if(val=='.'){
                    continue;
                }
                if(row[r].contains(val)){
                    return false;
                }else{
                    row[r].add(val);
                }
                if(col[c].contains(val)){
                    return false;
                }else{
                    col[c].add(val);
                }
                int index = (r/3)*3 + (c/3);
                if(box[index].contains(val)){
                    return false;
                }else{
                    box[index].add(val);
                }
            } 
        }
        
    return true;
    }

}
