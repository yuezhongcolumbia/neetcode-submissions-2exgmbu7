class Solution {
    private boolean[] col;
    private boolean[] posDiag;
    private boolean[] negDiag;
    int res;
    public int totalNQueens(int n) {
        col = new boolean[n];
        posDiag = new boolean[2 * n];
        negDiag = new boolean[2 * n]; 
        res = 0; 
        backtrack(n, 0);
        return res;  
    }
    public void backtrack(int n, int r){
        if (r == n) {
            res ++;
            return;
        }
        for (int c = 0;  c < n; c++){
            if (!col[c] && !posDiag[r + c] && !negDiag[r - c + n]){
                col[c] = true;
                posDiag[r + c] = true;
                negDiag[r - c + n] = true;
                backtrack(n, r + 1);
                col[c] = false;
                posDiag[r + c] = false;
                negDiag[r - c + n] = false;
            } 
        }
        
    }
    
}