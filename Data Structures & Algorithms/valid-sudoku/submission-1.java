class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Set<Character>> rowMap = new HashMap<>();
        HashMap<Integer, Set<Character>> colMap = new HashMap<>();
        HashMap<Integer, Set<Character>> boxMap = new HashMap<>();
        int m = board.length;
        int n = board[0].length;
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                char cur = board[r][c];
                if (cur != '.'){
                    int boxRow = r / 3;
                    int boxCol = c / 3;
                    int box = (boxRow ) * 3 + boxCol;
                    if (!boxMap.computeIfAbsent(box, k -> new HashSet<>()).add(cur)) return false;
                    if (!rowMap.computeIfAbsent(r, k -> new HashSet<>()).add(cur)) return false;
                    if (!colMap.computeIfAbsent(c, k -> new HashSet<>()).add(cur)) return false;
                }
                
            }
        }
        return true;
    }
}
