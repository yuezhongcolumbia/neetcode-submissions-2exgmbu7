class Solution {
    public boolean isValidSudoku(char[][] board) {
       Map<Integer, Set<Integer>> rowValid = new HashMap<>();
       Map<Integer, Set<Integer>> colValid = new HashMap<>();
       Map<Integer, Set<Integer>> gridValid = new HashMap<>();
       for(int i = 0; i < 9; i++){
         rowValid.put(i, new HashSet<>());
         colValid.put(i, new HashSet<>());
         gridValid.put(i, new HashSet<>());
       } 
        int rows = board.length;
        int cols = board[0].length;
        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                if (board[r][c] == '.') continue;
                int grid = r/3 * 3+ c/3;
                int num = board[r][c] - '0';
                if (rowValid.get(r).contains(num)
                    || colValid.get(c).contains(num)
                    || gridValid.get(grid).contains(num)){
                        return false;
                    }
                rowValid.get(r).add(num);
                colValid.get(c).add(num);
                gridValid.get(grid).add(num);
            }
        }
        return true;
    }
}
